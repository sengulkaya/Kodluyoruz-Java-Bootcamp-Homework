package kaya.sengul.app.service.rest.ticketreservation.converter;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class PegasusAirlinesConverter {
    public PegasusAirlinesResponseDTO toPegasusAirlinesFlightResponseDTO(PegasusAirlines pegasusAirlines)
    {
        PegasusAirlinesResponseDTO pegasusAirlinesResponseDTO = new PegasusAirlinesResponseDTO();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= pegasusAirlines.getTickets().size(); i++) {
            set.add(i);
        }
        return pegasusAirlinesResponseDTO
                .setId(pegasusAirlines.getFlightId())
                .setName(pegasusAirlines.getName())
                .setCapacity(pegasusAirlines.getCapacity())
                .setCityOfDeparture(pegasusAirlines.getCityOfDeparture())
                .setCityOfArrival(pegasusAirlines.getCityOfArrival())
                .setBookedSeats(set)
                /*.setDepartureTime(pegasusAirlines.getDepartureTime())*/;

    }

    public PegasusAirlines toPegasusAirlines(PegasusAirlinesRequestDTO requestDTO)
    {
        PegasusAirlines pegasusAirlines = new PegasusAirlines();

        pegasusAirlines.setName(requestDTO.getName())
                .setCapacity(requestDTO.getCapacity())
                .setBaseFare(requestDTO.getBaseFare())
                .setInternational(requestDTO.isInternational())
                .setCityOfDeparture(requestDTO.getCityOfDeparture())
                .setCityOfArrival(requestDTO.getCityOfArrival())
        /*.setDepartureTime(turkishAirlinesRequestDTO.getDepartureTime())*/;

        return pegasusAirlines;
    }
}


