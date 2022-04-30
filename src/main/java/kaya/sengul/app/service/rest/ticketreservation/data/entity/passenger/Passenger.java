package kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Passengers")
public abstract class Passenger {
    @Id
    @Column(name = "passenger_ıd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long passengerId;

    @Column(name = "passenger_name", nullable = false)
    protected String name;

    @Column(name = "passenger_age", nullable = false)
    protected int age;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn
    @Column(name = "passengerTickets", nullable = false)
    @ElementCollection(targetClass=Ticket.class)
    protected Set<Ticket> passengerTickets = new HashSet<>();


    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Ticket> getPassengerTickets() {
        return passengerTickets;
    }

    public void setPassengerTickets(Set<Ticket> passengerTickets) {
        this.passengerTickets = passengerTickets;
    }
}
