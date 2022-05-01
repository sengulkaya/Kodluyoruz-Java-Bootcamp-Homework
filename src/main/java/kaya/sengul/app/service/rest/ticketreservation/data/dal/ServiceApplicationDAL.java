package kaya.sengul.app.service.rest.ticketreservation.data.dal;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.IPassengerRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.IPegasusAirlinesRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.ITicketRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.ITurkishAirlinesRepository;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Component;


@Component
public class ServiceApplicationDAL {
    private final IPegasusAirlinesRepository m_pegasusAirlinesRepository;
    private final ITurkishAirlinesRepository m_turkishAirlinesRepository;
    private final IPassengerRepository m_passengerRepository;
    private final ITicketRepository m_ticketRepository;


    public ServiceApplicationDAL(IPegasusAirlinesRepository pegasusAirlinesRepository,
                                 ITurkishAirlinesRepository turkishAirlinesRepository,
                                 IPassengerRepository passengerRepository,
                                 ITicketRepository ticketRepository)
    {
        m_pegasusAirlinesRepository = pegasusAirlinesRepository;
        m_turkishAirlinesRepository = turkishAirlinesRepository;
        m_passengerRepository = passengerRepository;
        m_ticketRepository = ticketRepository;
    }

    public Ticket findTicketById(Long ticketId)
    {
        return m_ticketRepository.findById(ticketId).get();
    }

    public void cancelTicket(Ticket ticket)
    {
        m_ticketRepository.delete(ticket);
    }


    public void cancelPegasusAirlinesFlight(PegasusAirlines pegasusAirlines)
    {
        m_pegasusAirlinesRepository.delete(pegasusAirlines);
    }

    public void cancelTurkishAirlinesFlight(TurkishAirlines turkishAirlines)
    {
        m_turkishAirlinesRepository.delete(turkishAirlines);
    }
    public TurkishAirlines saveTurkishAirlinesFlight(TurkishAirlines turkishAirlines)
    {

        return m_turkishAirlinesRepository.save(turkishAirlines);
    }

    public TurkishAirlines findTurkishAirlinesFlightById(Long flightId)
    {

        return m_turkishAirlinesRepository.findById(flightId).orElseThrow();
    }

    public Iterable<TurkishAirlines> findTurkishAirlinesFlights()
    {

        return m_turkishAirlinesRepository.findAll();
    }

    public PegasusAirlines savePegasusAirlinesFlight(PegasusAirlines pegasusAirlines)
    {

        return m_pegasusAirlinesRepository.save(pegasusAirlines);
    }

    public PegasusAirlines findPegasusAirlinesFlightById(Long flightId)
    {

        return m_pegasusAirlinesRepository.findById(flightId).orElseThrow();
    }

    public Iterable<PegasusAirlines> findPegasusAirlinesFlights()
    {

        return m_pegasusAirlinesRepository.findAll();
    }


    public Ticket saveTurkishAirlinesTicket(Ticket ticket)
    {

        return m_ticketRepository.save((ticket));
    }

    public Iterable<Ticket> findTurkishAirlinesTicketsByPassengerId(Long passengerId)
    {
        return m_ticketRepository.findByPassengerId(passengerId);
    }

    public Iterable<Ticket> findTurkishAirlinesTickets()
    {
        return m_ticketRepository.findAll();
    }


    public Ticket savePegasusAirlinesTicket(Ticket ticket)
    {

        return m_ticketRepository.save((ticket));
    }

    public Iterable<Ticket> findPegasusAirlinesTicketsByPassengerId(Long passengerId)
    {
        return m_ticketRepository.findByPassengerId(passengerId);
    }

    public Iterable<Ticket> findPegasusAirlinesTickets()
    {
        return m_ticketRepository.findAll();
    }

    public Passenger updatePassenger(Long passengerId)
    {
        Passenger passenger = m_passengerRepository.findById(passengerId).get();
        return m_passengerRepository.save((passenger));
    }

    public Passenger savePassenger(Passenger passenger)
    {
        return m_passengerRepository.save((passenger));
    }


    public Passenger findPassengerById(Long passengerId)
    {
        return m_passengerRepository.findById(passengerId).orElseThrow();
    }


}
