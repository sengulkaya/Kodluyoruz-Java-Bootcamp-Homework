package kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.BookingClass;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.Set;

@Component
public class TicketRequestDTO {
    //private LocalDate departureTime;
    private BookingClass bookingClass;
    private long passengerId;
    private long flightId;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }


    /*public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }*/

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

}
