package kaya.sengul.app.service.rest.ticketreservation.converter;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Component;


@Component
public class PegasusAirlinesConverter {
    public PegasusAirlinesResponseDTO toPegasusAirlinesResponseDTO(PegasusAirlines pegasusAirlines)
    {
        PegasusAirlinesResponseDTO pegasusAirlinesResponseDTO = new PegasusAirlinesResponseDTO();

        return pegasusAirlinesResponseDTO.setName(pegasusAirlines.getName())
                .setCityOfDeparture(pegasusAirlines.getCityOfDeparture())
                .setCityOfArrival(pegasusAirlines.getCityOfArrival())
                /*.setDepartureTime(pegasusAirlines.getDepartureTime())*/;

    }
}


