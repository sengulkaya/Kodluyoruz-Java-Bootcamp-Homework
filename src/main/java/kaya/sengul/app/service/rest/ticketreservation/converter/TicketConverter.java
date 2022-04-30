package kaya.sengul.app.service.rest.ticketreservation.converter;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.Flight;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.BookingClass;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TicketConverter {
    public TicketResponseDTO toTicketResponseDTO(Ticket ticket)
    {
        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        //   private String passengerName;
        //    private BookingClass bookingClass;
        //    private int seatNumber;
        //    private String cityOfDeparture;
        //    private String cityOfArrival;
        //    private long flightId;

        return ticketResponseDTO.setBookingClass(ticket.getBookingClass())
                .setPassengerName(ticket.getPassenger().getName())
                .setBookingClass(ticket.getBookingClass())
                .setSeatNumber(ticket.getSeatNumber())
                .setCityOfDeparture(ticket.getCityOfDeparture())
                .setCityOfArrival(ticket.getCityOfArrival())
                .setAirline(ticket.getFlight().getName())
                //.setDepartureTime(ticket.getDepartureTime())
                ;

    }

    public Ticket toTicket(TicketRequestDTO ticketRequestDTO, Flight flight)
    {
        Ticket ticket = new Ticket();


        return ticket.setBookingClass(ticketRequestDTO.getBookingClass())
                .setCityOfDeparture(flight.getCityOfDeparture())
                .setCityOfArrival(flight.getCityOfArrival())
                .setFlightId(flight.getFlightId())
                .setPassengerId(ticketRequestDTO.getPassengerId())
                .setFare(flight.getBaseFare())
                .setInternational(flight.isInternational())

                //.setDepartureTime(ticket.getDepartureTime())
                ;

    }


}

