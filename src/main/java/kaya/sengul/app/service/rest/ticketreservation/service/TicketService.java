package kaya.sengul.app.service.rest.ticketreservation.service;


import kaya.sengul.app.service.rest.ticketreservation.converter.PassengerConverter;
import kaya.sengul.app.service.rest.ticketreservation.converter.TicketConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Service;
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
    public List<TicketResponseDTO> findTurkishAirlinesTicketByPassengerId(Long passengerId) throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesTicketsByPassengerId(passengerId).spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
    }

    public List<TicketResponseDTO> findTurkishAirlinesTickets() throws Exception {
        return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesTickets().spliterator(), false)
                .map(m_ticketConverter::toTicketResponseDTO)
                .collect(Collectors.toList());
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
            throw new RuntimeException("Flight is full");

        int seatNumber = size + 1;
        ticket.setSeatNumber(seatNumber);
        Set<Ticket> passengerTickets = passenger.getPassengerTickets();
        passengerTickets.add(ticket);
        ticket.setPassenger(passenger);
        //passenger.setPassengerTickets(passengerTickets);
        ticket.setFlight(flight);
        ticketSet.add(ticket);
        flight.setTickets(ticketSet);


        //m_serviceApplicationDAL.savePassenger(passenger);
        //m_serviceApplicationDAL.saveTurkishAirlinesFlight(flight);

        return m_ticketConverter.toTicketResponseDTO(m_serviceApplicationDAL.saveTurkishAirlinesTicket(ticket));
    }
}

