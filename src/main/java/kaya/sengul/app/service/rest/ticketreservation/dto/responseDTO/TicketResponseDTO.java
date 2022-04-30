package kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.BookingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TicketResponseDTO {
    private String passengerName;
    private BookingClass bookingClass;
    private String airline;
    private int seatNumber;
    private String cityOfDeparture;
    private String cityOfArrival;
    //private LocalDate departureTime;


    public String getAirline() {
        return airline;
    }

    public TicketResponseDTO setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public TicketResponseDTO setPassengerName(String passengerName) {
        this.passengerName = passengerName;
        return this;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public TicketResponseDTO setBookingClass(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
        return this;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public TicketResponseDTO setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public TicketResponseDTO setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public TicketResponseDTO setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    /*public LocalDate getDepartureTime() {
        return departureTime;
    }

    public TicketResponseDTO setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
        return this;
    }*/

    public String toString()
    {
        return String.format("%s %s depart from %s to %s", bookingClass.name(),
                passengerName, cityOfDeparture, cityOfArrival/*,
                departureTime*/);
    }
}


