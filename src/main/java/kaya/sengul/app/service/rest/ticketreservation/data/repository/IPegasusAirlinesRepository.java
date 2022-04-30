package kaya.sengul.app.service.rest.ticketreservation.data.repository;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPegasusAirlinesRepository extends CrudRepository<TurkishAirlines, Long> {

}