package kaya.sengul.app.service.rest.ticketreservation.data.dal;


import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.IPassengerRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.IPegasusAirlinesRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.ITicketRepository;
import kaya.sengul.app.service.rest.ticketreservation.data.repository.ITurkishAirlinesRepository;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.callbackinterfaces.ISupplierCallback;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.repository.RepositoryException;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class ServiceApplicationDAL {
    private final IPegasusAirlinesRepository m_pegasusAirlinesRepository;
    private final ITurkishAirlinesRepository m_turkishAirlinesRepository;
    private final IPassengerRepository m_passengerRepository;
    private final ITicketRepository m_ticketRepository;

    private static <R> R doWorkForRepository(ISupplierCallback<R> supplier, String msg)
    {
        try {
            return supplier.get();
        }
        catch (Throwable ex) {
            throw new RepositoryException(msg, ex);
        }
    }


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
        try {
            return m_ticketRepository.findById(ticketId).get();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.findTicketById", cause);
        }
    }

    public void cancelTicket(Ticket ticket)
    {
        try {
            m_ticketRepository.delete(ticket);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.cancelTicket", cause);
        }
    }


    public void cancelPegasusAirlinesFlight(PegasusAirlines pegasusAirlines)
    {
        try {
            m_pegasusAirlinesRepository.delete(pegasusAirlines);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.cancelPegasusAirlinesFlight", cause);
        }
    }

    public void cancelTurkishAirlinesFlight(TurkishAirlines turkishAirlines)
    {
        try {
            m_turkishAirlinesRepository.delete(turkishAirlines);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.cancelTurkishAirlinesFlight", cause);
        }
    }

    public TurkishAirlines saveTurkishAirlinesFlight(TurkishAirlines turkishAirlines)
    {
        try {
            return m_turkishAirlinesRepository.save(turkishAirlines);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.saveTurkishAirlinesFlight", cause);
        }
    }

    public TurkishAirlines findTurkishAirlinesFlightById(Long flightId)
    {
        try {
            return m_turkishAirlinesRepository.findById(flightId).orElseThrow();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.findTurkishAirlinesFlightById", cause);
        }
    }

    public Iterable<TurkishAirlines> findTurkishAirlinesFlights()
    {
        return doWorkForRepository(m_turkishAirlinesRepository::findAll,
                "ServiceApplicationDAL.findTurkishAirlinesFlights");
    }

    public PegasusAirlines savePegasusAirlinesFlight(PegasusAirlines pegasusAirlines)
    {
        try {
            return m_pegasusAirlinesRepository.save(pegasusAirlines);
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.savePegasusAirlinesFlight", cause);
        }
    }

    public PegasusAirlines findPegasusAirlinesFlightById(Long flightId)
    {
        try {
            return m_pegasusAirlinesRepository.findById(flightId).orElseThrow();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.findPegasusAirlinesFlightById", cause);
        }
    }

    public Iterable<PegasusAirlines> findPegasusAirlinesFlights()
    {
        return doWorkForRepository(m_pegasusAirlinesRepository::findAll,
                "ServiceApplicationDAL.findPegasusAirlinesFlights");
    }


    public Ticket saveTurkishAirlinesTicket(Ticket ticket)
    {
        try {
            return m_ticketRepository.save((ticket));
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.saveTurkishAirlinesTicket", cause);
        }
    }

    public Iterable<Ticket> findTurkishAirlinesTickets()
    {
        return doWorkForRepository(m_ticketRepository::findAll,
                "ServiceApplicationDAL.findTurkishAirlinesTickets");
    }


    public Ticket savePegasusAirlinesTicket(Ticket ticket)
    {
        try {
            return m_ticketRepository.save((ticket));
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.savePegasusAirlinesTicket", cause);
        }
    }


    public Iterable<Ticket> findPegasusAirlinesTickets()
    {
        return doWorkForRepository(m_ticketRepository::findAll,
                "ServiceApplicationDAL.findPegasusAirlinesTickets");
    }

    public Passenger updatePassenger(Long passengerId)
    {
        try {
            Passenger passenger = m_passengerRepository.findById(passengerId).get();
            return m_passengerRepository.save((passenger));
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.updatePassenger", cause);
        }

    }

    public Passenger savePassenger(Passenger passenger)
    {
        try {
            return m_passengerRepository.save((passenger));
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.savePassenger", cause);
        }
    }


    public Passenger findPassengerById(Long passengerId)
    {
        try {
            return m_passengerRepository.findById(passengerId).orElseThrow();
        } catch (Throwable cause) {
            throw new RepositoryException("ServiceApplicationDAL.findPassengerById", cause);
        }
    }

    /*public Iterable<Ticket> findTurkishAirlinesTicketsByPassengerId(Long passengerId)
    {
        return m_ticketRepository.findByPassengerId(passengerId);
    }

    public Iterable<Ticket> findPegasusAirlinesTicketsByPassengerId(Long passengerId)
    {
        return m_ticketRepository.findByPassengerId(passengerId);
    }*/


}
