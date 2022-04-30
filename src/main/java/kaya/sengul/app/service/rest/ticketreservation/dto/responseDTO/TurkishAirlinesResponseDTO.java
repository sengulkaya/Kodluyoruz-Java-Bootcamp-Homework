package kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class TurkishAirlinesResponseDTO {
    private long id;
    private String name;
    private int capacity;
    private String cityOfDeparture;
    private String cityOfArrival;
    //private LocalDate departureTime;
    private Set<Integer> bookedSeats = new HashSet<>();

    public long getId() {
        return id;
    }

    public TurkishAirlinesResponseDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TurkishAirlinesResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public TurkishAirlinesResponseDTO setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }


    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public TurkishAirlinesResponseDTO setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public TurkishAirlinesResponseDTO setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    /*public LocalDate getDepartureTime() {
        return departureTime;
    }

    public TurkishAirlinesResponseDTO setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
        return this;
    }*/

    public Set<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public TurkishAirlinesResponseDTO setBookedSeats(Set<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
        return this;
    }

    public String toString()
    {
        return String.format("%s %s - %s", name, cityOfDeparture, cityOfArrival);
    }
}
