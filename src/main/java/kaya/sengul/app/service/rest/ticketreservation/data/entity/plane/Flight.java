package kaya.sengul.app.service.rest.ticketreservation.data.entity.plane;

import com.fasterxml.jackson.annotation.JsonFormat;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

@Entity
@Table(name = "Flights")
public abstract class Flight implements IFlightService{
    @Id
    @Column(name = "flight_ıd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long flightId;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "capacity", nullable = false)
    protected int capacity;

    @Column(name = "baseFare", nullable = false)
    protected double baseFare;

    @Column(name = "international", nullable = false)
    protected boolean international;

    @Column(name = "city_of_departure", nullable = false)
    protected String cityOfDeparture;

    @Column(name = "city_of_arrival", nullable = false)
    protected String cityOfArrival;

    /*@Column(name = "flight_code")
    protected String flightCode;*/

    /*@Column(name = "departure_time", nullable = false)
    protected LocalDate departureTime;*/


    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn
    @Column(name = "flightTickets", nullable = false)
    @ElementCollection(targetClass=Ticket.class)
    protected Set<Ticket> flightTickets = new HashSet<>();

    /*private String getIdForDestination(String city)
    {
        char[] chars = city.toCharArray();
        int id = 0;
        for (char ch : chars) {
            id += ch - 'A';
        }

        return String.format("%02d", id);
    }*/

    public long getFlightId() {
        return flightId;
    }

    public Flight setFlightId(long flightId) {
        this.flightId = flightId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Flight setName(String name) {
        this.name = name;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public Flight setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }


    public boolean isInternational() {
        return international;
    }
    public Flight setInternational(boolean international) {
        this.international = international;
        return this;
    }

    public Set<Ticket> getTickets() {
        return flightTickets;
    }
    public Flight setTickets(Set<Ticket> tickets) {
        this.flightTickets = tickets;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }
    public Flight setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }
    public Flight setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        //setFlightCode();
        return this;
    }

    /*public String getFlightCode() {
        return flightCode;
    }
    public Flight setFlightCode() {
        this.flightCode = name.chars().
                filter(Character :: isUpperCase).
                mapToObj(ch -> (char) ch).
                collect(Collector.of(StringBuilder :: new, StringBuilder::append, StringBuilder::append,
                        StringBuilder :: toString)) + getIdForDestination(cityOfDeparture) + getIdForDestination(cityOfArrival);
        return this;
    }*/

    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    @NonNull
    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public Flight setDepartureTime(LocalDate departureTime) throws Exception
    {

        if (!departureTime.isAfter(this.departureTime)) {
            throw new Exception("Please set proper departure time!");
        }
        this.departureTime = departureTime;
        return this;
    }*/

    public double getBaseFare() {
        return baseFare;
    }

    public Flight setBaseFare(double baseFare) {
        this.baseFare = baseFare;
        return this;
    }
}
