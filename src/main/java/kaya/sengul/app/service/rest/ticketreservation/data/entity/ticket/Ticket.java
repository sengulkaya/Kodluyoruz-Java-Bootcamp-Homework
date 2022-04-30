package kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket;

import com.fasterxml.jackson.annotation.JsonFormat;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Tickets")
public class Ticket {
    @Id
    @Column(name = "ticket_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booking_class",nullable = false)
    private BookingClass bookingClass;

    @Column(name = "international", nullable = false)
    private boolean international;

    @Column(name = "city_of_departure", nullable = false)
    private String cityOfDeparture;

    @Column(name = "city_of_arrival", nullable = false)
    private String cityOfArrival;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;


    /*@Column(name = "departure_time", nullable = false)
    private LocalDate departureTime;*/

    @Column(name = "fare", nullable = false)
    private double fare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_ıd")
    private Flight flight;

    @Transient
    private long flightId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_ıd")
    private Passenger passenger;

    @Transient
    private long passengerId;

    public long getFlightId() {
        return flightId;
    }

    public Ticket setFlightId(long flightId) {
        this.flightId = flightId;
        return this;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public Ticket setPassengerId(long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Ticket setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }


    public long getId() {
        return id;
    }

    public Ticket setId(long id) {
        this.id = id;
        return this;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public Ticket setBookingClass(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
        return this;
    }

    public boolean isInternational() {
        return international;
    }

    public Ticket setInternational(boolean international) {
        this.international = international;
        return this;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public Ticket setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public Ticket setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Ticket setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    /*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    @NonNull
    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public Ticket setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
        return this;
    }*/

    public double getFare() {
        return fare;
    }

    public Ticket setFare(double fare) {
        this.fare = (bookingClass == BookingClass.BUSINESS ? 2 : 1) * fare;
        return this;
    }

    public Flight getFlight() {
        return flight;
    }

    public Ticket setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", bookingClass=" + bookingClass +
                ", international=" + international +
                ", cityOfDeparture='" + cityOfDeparture + '\'' +
                ", cityOfArrival='" + cityOfArrival + '\'' +
                ", seatNumber=" + seatNumber +
                ", fare=" + fare +
                ", passengerName=" + passenger.getName() +
                '}';
    }
}
