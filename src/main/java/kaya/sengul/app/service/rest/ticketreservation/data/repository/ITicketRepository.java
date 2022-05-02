package kaya.sengul.app.service.rest.ticketreservation.data.repository;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITicketRepository extends CrudRepository<Ticket, Long> {
    //@Query(value = "select ticket from Tickets ticket where ticket.passengerId = :passengerId", nativeQuery = true)
    //Iterable<Ticket> findByPassengerId(long passengerId);
}
