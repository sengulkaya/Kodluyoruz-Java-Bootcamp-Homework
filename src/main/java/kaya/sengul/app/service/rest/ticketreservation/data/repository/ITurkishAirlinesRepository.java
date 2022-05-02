package kaya.sengul.app.service.rest.ticketreservation.data.repository;


import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.TurkishAirlines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurkishAirlinesRepository extends CrudRepository<TurkishAirlines, Long> {
}
