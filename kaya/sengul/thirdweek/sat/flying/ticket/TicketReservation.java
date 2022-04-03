package kaya.sengul.thirdweek.sat.flying.ticket;
import kaya.sengul.thirdweek.sat.flying.passenger.Adult;
import kaya.sengul.thirdweek.sat.flying.passenger.Passenger;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicketReservation {
    private final TicketService m_ticketService;

    public TicketReservation(TicketService ticketService)
    {
        m_ticketService = ticketService;
    }
    public void reserveTicket(boolean international, BookingClass bookingClass, Passenger passenger, int seatNumber)
    {
        m_ticketService.buyTicket(international, bookingClass,
                passenger, seatNumber);

    }
    public void run()
    {
        java.util.Scanner kb = new Scanner(System.in);
        java.util.Random rand = new Random();

        for (;;) {
            System.out.print("Q for Quit?: ");
            System.out.print("Name?: ");
            String name = kb.nextLine();

            if (name.equals("Q"))
                break;

            System.out.print("Surname?: ");
            String surname = kb.nextLine();

            Passenger passenger = new Adult(name, surname);//Passenger sýnfýndan türeyenlere age eklenip
                                                            //ona göre sorgu yapýlýp ilgili sýnýf yaratýlabilirdi.

            int seatNumber = rand.nextInt(180) + 1;
            boolean international = rand.nextBoolean();
            BookingClass bookingClass = seatNumber % 2 == 0 ? BookingClass.BUSINESS : BookingClass.ECONOMY;


            reserveTicket(international, bookingClass, passenger, seatNumber);
        }

    }
}
