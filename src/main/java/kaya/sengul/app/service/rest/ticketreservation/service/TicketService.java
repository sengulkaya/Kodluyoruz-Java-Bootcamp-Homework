package kaya.sengul.app.service.rest.ticketreservation.service;


import kaya.sengul.app.service.rest.ticketreservation.converter.PassengerConverter;
import kaya.sengul.app.service.rest.ticketreservation.converter.TicketConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.Flight;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.callbackinterfaces.ISupplierCallback;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.repository.RepositoryException;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.service.PegasusAirlinesServiceException;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.service.TicketServiceException;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TicketService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final TicketConverter m_ticketConverter;


    private int getAvailableSeatNumber(Flight flight)
    {
        Set<Ticket> ticketSet = flight.getTickets();
        Set<Integer> seatNumbers = new HashSet<>();
        java.util.Random rand = new Random();

        for (var val : ticketSet) {
            seatNumbers.add(val.getSeatNumber());
        }

        int seatNumber;
        while (true) {
            seatNumber = rand.nextInt(flight.getCapacity()) + 1;
            if (!seatNumbers.contains(seatNumber))
                break;
        }
        return seatNumber;
    }


    public TicketService(ServiceApplicationDAL serviceApplicationDAL,
                         TicketConverter converter,
                         TurkishAirlinesService turkishAirlinesService,
                         PegasusAirlinesService pegasusAirlinesService,
                         PassengerService passengerService,
                         PassengerConverter passengerConverter)
    {
        m_serviceApplicationDAL = serviceApplicationDAL;
        m_ticketConverter = converter;
    }

    @Transactional
    public TicketResponseDTO reserveTurkishAirlinesTicket(TicketRequestDTO ticketRequestDTO)
    {
        try {
            long passengerId = ticketRequestDTO.getPassengerId();
            long flightId = ticketRequestDTO.getFlightId();

            TurkishAirlines flight = m_serviceApplicationDAL.findTurkishAirlinesFlightById(flightId);
            Passenger passenger = m_serviceApplicationDAL.findPassengerById(passengerId);
            Ticket ticket = m_ticketConverter.toTicket(ticketRequestDTO, flight);

            Set<Ticket> ticketSet = flight.getTickets();

            int size = ticketSet.size();
            if (size == flight.getCapacity())
                throw new Exception("Flight is full");

            ticket.setSeatNumber(getAvailableSeatNumber(flight));
            Set<Ticket> passengerTickets = passenger.getPassengerTickets();
            passengerTickets.add(ticket);
            ticket.setPassenger(passenger);
            ticket.setFlight(flight);
            ticketSet.add(ticket);
            flight.setTickets(ticketSet);


            return m_ticketConverter.toTicketResponseDTO(m_serviceApplicationDAL.saveTurkishAirlinesTicket(ticket));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.reserveTurkishAirlinesTicket", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.reserveTurkishAirlinesTicket", ex);
        }

    }

    public TicketResponseDTO cancelTurkishAirlinesTicket(Long ticketId) {
        try {
            Ticket ticket = m_serviceApplicationDAL.findTicketById(ticketId);
            m_serviceApplicationDAL.cancelTicket(ticket);
            return m_ticketConverter.toTicketResponseDTO(ticket);
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.cancelTurkishAirlinesTicket", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.cancelTurkishAirlinesTicket", ex);
        }
    }

    public List<TicketResponseDTO> findTurkishAirlinesTickets() {
        try {
            return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesTickets().spliterator(), false)
                    .map(m_ticketConverter::toTicketResponseDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.findTurkishAirlinesTickets", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.findTurkishAirlinesTickets", ex);
        }
    }

    @Transactional
    public TicketResponseDTO reservePegasusAirlinesTicket(TicketRequestDTO ticketRequestDTO)
    {
        try {
            long passengerId = ticketRequestDTO.getPassengerId();
            long flightId = ticketRequestDTO.getFlightId();

            PegasusAirlines flight = m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId);
            Passenger passenger = m_serviceApplicationDAL.findPassengerById(passengerId);
            Ticket ticket = m_ticketConverter.toTicket(ticketRequestDTO, flight);

            Set<Ticket> ticketSet = flight.getTickets();

            int size = ticketSet.size();
            if (size == flight.getCapacity())
                throw new Exception("Flight is full");


            ticket.setSeatNumber(getAvailableSeatNumber(flight));
            Set<Ticket> passengerTickets = passenger.getPassengerTickets();
            passengerTickets.add(ticket);
            ticket.setPassenger(passenger);
            ticket.setFlight(flight);
            ticketSet.add(ticket);
            flight.setTickets(ticketSet);


            return m_ticketConverter.toTicketResponseDTO(m_serviceApplicationDAL.savePegasusAirlinesTicket(ticket));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.reservePegasusAirlinesTicket", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.reservePegasusAirlinesTicket", ex);
        }
    }

    public TicketResponseDTO cancelPegasusAirlinesTicket(Long ticketId) {
        try {
            Ticket ticket = m_serviceApplicationDAL.findTicketById(ticketId);
            m_serviceApplicationDAL.cancelTicket(ticket);
            return m_ticketConverter.toTicketResponseDTO(ticket);
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.cancelPegasusAirlinesTicket", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.cancelPegasusAirlinesTicket", ex);
        }
    }

    public List<TicketResponseDTO> findPegasusAirlinesTickets() {
        try {
            return StreamSupport.stream(m_serviceApplicationDAL.findPegasusAirlinesTickets().spliterator(), false)
                    .map(m_ticketConverter::toTicketResponseDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TicketServiceException("TicketService.findPegasusAirlinesTickets", ex.getCause());
        } catch (Throwable ex) {
            throw new TicketServiceException("TicketService.findPegasusAirlinesTickets", ex);
        }
    }




   /* public List<TicketResponseDTO> findPegasusAirlinesTicketByPassengerId(Long passengerId) throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findPegasusAirlinesTicketsByPassengerId(passengerId).spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TicketResponseDTO> findTurkishAirlinesTicketByPassengerId(Long passengerId) throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesTicketsByPassengerId(passengerId).spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
    }*/
}

