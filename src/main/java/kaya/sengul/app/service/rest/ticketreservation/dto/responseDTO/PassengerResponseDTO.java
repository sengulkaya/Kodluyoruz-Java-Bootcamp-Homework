package kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PassengerResponseDTO {
    private long passengerId;
    private String name;
    private Set<TicketResponseDTO> tickets;

    public String getName() {
        return name;
    }

    public PassengerResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public PassengerResponseDTO setPassengerId(long passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public Set<TicketResponseDTO> getTickets() {
        return tickets;
    }

    public PassengerResponseDTO setTickets(Set<TicketResponseDTO> tickets) {
        this.tickets = tickets;
        return this;
    }
}
