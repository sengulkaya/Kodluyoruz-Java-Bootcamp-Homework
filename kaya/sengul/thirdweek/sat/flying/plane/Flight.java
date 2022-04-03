package kaya.sengul.thirdweek.sat.flying.plane;

import kaya.sengul.thirdweek.sat.flying.ticket.BookingClass;
import kaya.sengul.thirdweek.sat.flying.ticket.Ticket;

import java.time.LocalDateTime;

public class Flight {
    private final boolean m_international;
    private final Plane m_plane;
    private final Ticket[] tickets;
    private String m_flightCode;
    private final String m_from;
    private final String m_to;
    private LocalDateTime departureTime;

    private String getIdForDestination(String city)
    {
        char[] fromChars = city.toCharArray();
        int id = 0;
        for (char ch : fromChars) {
            id += ch - 'A';
        }

        return String.format("%02d", id);
    }

    private void setFlightCode(Plane plane)
    {
        this.m_flightCode = plane.getCode() +
                getIdForDestination(m_from) +
                getIdForDestination(m_to);
    }

    public Flight(boolean international, Plane plane, String from, String to, LocalDateTime departureTime)//Set<? extends Passenger> passengers
    {
        this.m_international = international;
        this.m_plane = plane;
        this.m_from = from;
        this.m_to = to;
        this.tickets = new Ticket[plane.capacity + 1];//Dizi indeksi koltuk no ifade edecek
        this.departureTime = departureTime;
        setFlightCode(plane);

    }

    public boolean isInternational() {
        return m_international;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Plane getPlane() {
        return m_plane;
    }

    public String getFlightCode() {
        return m_flightCode;
    }

    public String getFrom() {
        return m_from;
    }

    public String getTo() {
        return m_to;
    }

    public LocalDateTime getDepartureTime() {//

        LocalDateTime copy = LocalDateTime.of(departureTime.getYear(),
                departureTime.getMonth(), departureTime.getDayOfMonth(),
                departureTime.getHour(), departureTime.getMinute());

        return copy;
    }

    public void setDepartureTime(LocalDateTime departureTime) {

        if (departureTime.compareTo(this.departureTime) <= 0) {//Uçuþ daha erken olamayacaðý için
            System.out.println("Please set proper departure time!");
            return;
        }
        this.departureTime = departureTime;
    }


    public void foodService()
    {
        m_plane.serveFood(m_international);
    }

    public String toString()
    {
        return String.format("%s %s flight %s %s - %s on %02d/%02d/%04d will depart at %02d:%02d",
                m_plane.brand, m_international ? "international" : "domestic",  m_flightCode, m_from, m_to,
                departureTime.getDayOfMonth(), departureTime.getMonthValue(),
                departureTime.getYear(), departureTime.getHour(), departureTime.getMinute());
    }
}
