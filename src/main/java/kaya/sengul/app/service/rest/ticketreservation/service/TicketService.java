package kaya.sengul.app.service.rest.ticketreservation.service;


import kaya.sengul.app.service.rest.ticketreservation.converter.PassengerConverter;
import kaya.sengul.app.service.rest.ticketreservation.converter.TicketConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.Flight;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TicketService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final TicketConverter m_ticketConverter;
    private final TurkishAirlinesService m_turkishAirlinesService;
    private final PegasusAirlinesService m_pegasusAirlinesService;
    private final PassengerService m_passengerService;
    private final PassengerConverter m_passengerConverter;

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
        m_pegasusAirlinesService = pegasusAirlinesService;
        m_turkishAirlinesService = turkishAirlinesService;
        m_passengerService = passengerService;
        m_passengerConverter = passengerConverter;
    }

    @Transactional
    public TicketResponseDTO reserveTurkishAirlinesTicket(TicketRequestDTO ticketRequestDTO) throws Exception
    {
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
    }

    public TicketResponseDTO cancelTurkishAirlinesTicket(Long ticketId) {

        Ticket ticket = m_serviceApplicationDAL.findTicketById(ticketId);
        m_serviceApplicationDAL.cancelTicket(ticket);
        return m_ticketConverter.toTicketResponseDTO(ticket);
    }

    public List<TicketResponseDTO> findTurkishAirlinesTickets() throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesTickets().spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TicketResponseDTO reservePegasusAirlinesTicket(TicketRequestDTO ticketRequestDTO) throws Exception
    {
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
    }

    public TicketResponseDTO cancelPegasusAirlinesTicket(Long ticketId) {

        Ticket ticket = m_serviceApplicationDAL.findTicketById(ticketId);
        m_serviceApplicationDAL.cancelTicket(ticket);
        return m_ticketConverter.toTicketResponseDTO(ticket);
    }

    public List<TicketResponseDTO> findPegasusAirlinesTickets() throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findPegasusAirlinesTickets().spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
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

