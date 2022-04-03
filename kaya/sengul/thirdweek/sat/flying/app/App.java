package kaya.sengul.thirdweek.sat.flying.app;

import kaya.sengul.thirdweek.sat.flying.plane.Flight;
import kaya.sengul.thirdweek.sat.flying.plane.PegasusAirlines;
import kaya.sengul.thirdweek.sat.flying.ticket.Ticket;
import kaya.sengul.thirdweek.sat.flying.ticket.TicketReservation;
import kaya.sengul.thirdweek.sat.flying.ticket.TicketService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Flight> list = new ArrayList<Flight>(4);

        list.add(new Flight(true, new PegasusAirlines(180,
                "Turkish Airlines"), "IST", "AMS",
                LocalDateTime.of(2022, Month.APRIL, 20, 18, 30)));

        list.add(new Flight(false, new PegasusAirlines(180,
                "Pegasus Airlines"), "IST", "ADA",
                LocalDateTime.of(2022, Month.APRIL, 20, 18, 30)));

        list.add(new Flight(true, new PegasusAirlines(180,
                        "Pegasus Airlines"), "IST", "BER",
                LocalDateTime.of(2022, Month.APRIL, 20, 18, 30)));

        list.add(new Flight(false, new PegasusAirlines(180,
                "Pegasus Airlines"), "IST", "IZM",
                LocalDateTime.of(2022, Month.APRIL, 20, 18, 30)));



        TicketService ticketService = new TicketService(list);
        TicketReservation ticketReservation = new TicketReservation(ticketService);
        ticketReservation.run();

        for (var flight : list) {
            for (Ticket ticket : flight.getTickets()) {
                if (ticket != null) {
                    System.out.println(flight);
                    System.out.println(ticket);
                    ticket.getFlight().foodService();
                    System.out.println("---------------------------------------------------------------------------------");
                }

            }
        }
    }
}
