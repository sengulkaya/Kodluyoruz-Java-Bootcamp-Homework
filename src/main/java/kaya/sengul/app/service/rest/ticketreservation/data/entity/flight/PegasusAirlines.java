package kaya.sengul.app.service.rest.ticketreservation.data.entity.flight;




import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;

import javax.persistence.Entity;
import java.util.Set;


@Entity
public class PegasusAirlines extends Flight {

    @Override
    public void serveFood() {
        if (super.isInternational())
            System.out.println("Pegasus Airlines food service for international flights");
        else
            System.out.println("Pegasus Airlines food service for domestic flights");
    }

    @Override
    public Flight setCityOfDeparture(String cityOfDeparture) {
        return super.setCityOfDeparture(cityOfDeparture);
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

}