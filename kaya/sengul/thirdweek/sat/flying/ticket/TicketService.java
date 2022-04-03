package kaya.sengul.thirdweek.sat.flying.ticket;
import kaya.sengul.thirdweek.sat.flying.plane.Flight;
import kaya.sengul.thirdweek.sat.flying.passenger.Passenger;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TicketService {
    private final List<Flight> m_flights;

    public TicketService(List<Flight> flights)
    {
        m_flights = flights;
    }

    public void buyTicket(boolean international, BookingClass bookingClass, Passenger passenger, int seatNumber)
    {

        Optional<Flight> flight = m_flights.stream().filter(f -> f.isInternational() == international).findFirst();

        Flight found = null;

        if (flight.isPresent()) {
            found = flight.get();
            found.getTickets()[seatNumber] = new Ticket(found, bookingClass, passenger, seatNumber);
        }

    }

    public void displayFlights()
    {
        for (var flight : m_flights) {
            System.out.println(flight.toString());
        }
    }

}
