package kaya.sengul.app.service.rest.ticketreservation.data.repository;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassengerRepository extends CrudRepository<Passenger, Long> {

}