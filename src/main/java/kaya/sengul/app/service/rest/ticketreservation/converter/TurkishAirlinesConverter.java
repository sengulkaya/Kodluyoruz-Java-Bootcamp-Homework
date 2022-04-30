package kaya.sengul.app.service.rest.ticketreservation.converter;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Component
public class TurkishAirlinesConverter {
    public TurkishAirlinesResponseDTO toTurkishAirlinesFlightResponseDTO(TurkishAirlines turkishAirlines)
    {
        TurkishAirlinesResponseDTO turkishAirlinesResponseDTO = new TurkishAirlinesResponseDTO();

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= turkishAirlines.getTickets().size(); i++) {
            set.add(i);
        }
        return turkishAirlinesResponseDTO
                .setId(turkishAirlines.getFlightId())
                .setName(turkishAirlines.getName())
                .setCapacity(turkishAirlines.getCapacity())
                .setCityOfDeparture(turkishAirlines.getCityOfDeparture())
                .setCityOfArrival(turkishAirlines.getCityOfArrival())
                .setBookedSeats(set)
                /*.setDepartureTime(turkishAirlines.getDepartureTime())*/;
                //id olmalı burada
    }

    public TurkishAirlines toTurkishAirlines(TurkishAirlinesRequestDTO requestDTO)
    {
        TurkishAirlines turkishAirlines = new TurkishAirlines();

        turkishAirlines.setName(requestDTO.getName())
                .setCapacity(requestDTO.getCapacity())
                .setBaseFare(requestDTO.getBaseFare())
                .setInternational(requestDTO.isInternational())
                .setCityOfDeparture(requestDTO.getCityOfDeparture())
                .setCityOfArrival(requestDTO.getCityOfArrival())
        /*.setDepartureTime(turkishAirlinesRequestDTO.getDepartureTime())*/;

        return turkishAirlines;
    }
}
