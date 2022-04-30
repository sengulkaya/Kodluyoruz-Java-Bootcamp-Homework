package kaya.sengul.app.service.rest.ticketreservation.data.entity.plane;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;


@Entity
public class TurkishAirlines extends Flight {
    @Override
    public void serveFood() {
        if (super.isInternational())
            System.out.println("Pegasus Airlines food service for international flights");
        else
            System.out.println("Pegasus Airlines food service for domestic flights");
    }

    @Override
    public long getFlightId() {
        return super.getFlightId();
    }

    @Override
    public Flight setFlightId(long flightId) {
        return super.setFlightId(flightId);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Flight setName(String name) {
        return super.setName(name);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public Flight setCapacity(int capacity) {
        return super.setCapacity(capacity);
    }

    @Override
    public boolean isInternational() {
        return super.isInternational();
    }

    @Override
    public Flight setInternational(boolean international) {
        return super.setInternational(international);
    }

    @Override
    public Set<Ticket> getTickets() {
        return super.getTickets();
    }

    @Override
    public Flight setTickets(Set<Ticket> tickets) {
        return super.setTickets(tickets);
    }

    @Override
    public String getCityOfArrival() {
        return super.getCityOfArrival();
    }

    @Override
    public Flight setCityOfArrival(String cityOfArrival) {
        return super.setCityOfArrival(cityOfArrival);
    }

    @Override
    public String getCityOfDeparture() {
        return super.getCityOfDeparture();
    }

    @Override
    public Flight setCityOfDeparture(String cityOfDeparture) {
        return super.setCityOfDeparture(cityOfDeparture);
    }

    /*@Override
    public String getFlightCode() {
        return super.getFlightCode();
    }

    @Override
    public Flight setFlightCode() {
        return super.setFlightCode();
    }*/

    @Override
    public double getBaseFare() {
        return super.getBaseFare();
    }

    @Override
    public Flight setBaseFare(double baseFare) {
        super.setBaseFare(baseFare);
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
