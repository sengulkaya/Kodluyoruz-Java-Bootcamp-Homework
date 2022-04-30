package kaya.sengul.app.service.rest.ticketreservation.converter;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class PassengerConverter {
    private final TicketConverter m_ticketConverter;

    public PassengerConverter(TicketConverter ticketConverter)
    {
        m_ticketConverter = ticketConverter;
    }
    public PassengerResponseDTO toPassengerResponseDTO(Passenger passenger)
    {
        PassengerResponseDTO passengerResponseDTO = new PassengerResponseDTO()
                .setName(passenger.getName())
                .setPassengerId(passenger.getPassengerId());
        Set<TicketResponseDTO> ticketResponseDTOS = new HashSet<>();
        for (var ticket : passenger.getPassengerTickets())
            ticketResponseDTOS.add(m_ticketConverter.toTicketResponseDTO(ticket));


        return passengerResponseDTO.setTickets(ticketResponseDTOS);
    }
}
