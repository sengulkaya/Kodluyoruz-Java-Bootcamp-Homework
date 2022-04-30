package kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class PegasusAirlinesResponseDTO {
    private String name;
    private String cityOfDeparture;
    private String cityOfArrival;
    //private LocalDate departureTime;
    private Set<Ticket> bookedTickets = new HashSet<>();

    public String getName() {
        return name;
    }

    public PegasusAirlinesResponseDTO setName(String name) {
        this.name = name;
        return this;
    }


    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public PegasusAirlinesResponseDTO setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public PegasusAirlinesResponseDTO setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    /*public LocalDate getDepartureTime() {
        return departureTime;
    }

    public PegasusAirlinesResponseDTO setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
        return this;
    }*/

    public Set<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public PegasusAirlinesResponseDTO setBookedTickets(Set<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
        return this;
    }
    public String toString()
    {
        return String.format("%s %s - %s", name, cityOfDeparture, cityOfArrival);
    }
}
