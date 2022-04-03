package kaya.sengul.thirdweek.sat.flying.ticket;

import kaya.sengul.thirdweek.sat.flying.plane.Flight;
import kaya.sengul.thirdweek.sat.flying.plane.Plane;
import kaya.sengul.thirdweek.sat.flying.passenger.Passenger;

public class Ticket {
    private final Flight m_flight;
    private boolean m_available;
    private final BookingClass m_bookingClass;
    private final Passenger m_passenger;
    private final int seatNumber;

    public Ticket(Flight flight, BookingClass bookingClass, Passenger passenger, int seatNumber)
    {
        this.m_flight = flight;
        this.m_bookingClass = bookingClass;
        this.m_passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public Flight getFlight() {
        return m_flight;
    }

    public String toString()
    {
        return String.format("%s flight %s %s class seat number %d is booked for %s %s", m_flight.getPlane().getBrand(),
                m_flight.getFlightCode(), m_bookingClass.name(), seatNumber, m_passenger.getName(), m_passenger.getSurname());
    }
}
