package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PegasusAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.callbackinterfaces.ISupplierCallback;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.repository.RepositoryException;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.service.PegasusAirlinesServiceException;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PegasusAirlinesService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final PegasusAirlinesConverter m_pegasusAirlinesConverter;

    public PegasusAirlinesService(ServiceApplicationDAL serviceApplicationDAL, PegasusAirlinesConverter converter)
    {
        m_serviceApplicationDAL = serviceApplicationDAL;
        m_pegasusAirlinesConverter = converter;
    }
    private static <T,R> R doWorkForPegasusAirlinesService(ISupplierCallback<R> supplier, Consumer<T> consumer, String msg)
    {
        try {
            return supplier.get();
        } catch (RepositoryException ex) {
            consumer.accept((T)ex);
            throw new PegasusAirlinesServiceException(msg, ex.getCause());
        }
        catch (Throwable ex) {
            throw new PegasusAirlinesServiceException(msg, ex);
        }
    }

    public PegasusAirlinesResponseDTO cancelFlight(Long flightId) throws Exception //new
    {
        try {
            PegasusAirlines pegasusAirlines = m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId);
            m_serviceApplicationDAL.cancelPegasusAirlinesFlight(pegasusAirlines);
            return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(pegasusAirlines);

        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.cancelFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.cancelFlight", ex);
        }
    }

    public PegasusAirlinesResponseDTO saveFlight(PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) throws Exception
    {
        try {
            return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(m_serviceApplicationDAL.savePegasusAirlinesFlight
                    (m_pegasusAirlinesConverter.toPegasusAirlines(pegasusAirlinesRequestDTO)));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.saveFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.saveFlight", ex);
        }
    }

    @Transactional
    public PegasusAirlinesResponseDTO updateFlight(Long flightId, PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) {
        try {
             PegasusAirlines flight = m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId);

        flight.setName(pegasusAirlinesRequestDTO.getName())
                .setCapacity(pegasusAirlinesRequestDTO.getCapacity())
                .setBaseFare(pegasusAirlinesRequestDTO.getBaseFare())
                .setInternational(pegasusAirlinesRequestDTO.isInternational())
                .setCityOfDeparture(pegasusAirlinesRequestDTO.getCityOfDeparture())
                .setCityOfArrival(pegasusAirlinesRequestDTO.getCityOfArrival());


        Set<Ticket> flightTickets = flight.getTickets();
        for (var ticket : flightTickets) {
            ticket.setInternational(flight.isInternational())
                    .setCityOfDeparture(flight.getCityOfDeparture())
                    .setCityOfArrival(flight.getCityOfArrival())
                    .setFare(flight.getBaseFare());
        }

        flight.setTickets(flightTickets);
        return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(
                m_serviceApplicationDAL.savePegasusAirlinesFlight(flight));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.updateFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.updateFlight", ex);
        }
    }

    public List<PegasusAirlinesResponseDTO> findPegasusAirlinesFlights()
    {
        try {
            return StreamSupport.stream(m_serviceApplicationDAL.findPegasusAirlinesFlights().spliterator(), false)
                    .map(m_pegasusAirlinesConverter :: toPegasusAirlinesFlightResponseDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.findPegasusAirlinesFlights", ex.getCause());
        } catch (Throwable ex) {
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.findPegasusAirlinesFlights", ex);
        }
    }

    public PegasusAirlinesResponseDTO findFlightById(Long flightId)
    {
        try {
            return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(
                    (m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId)));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.findFlightById", ex.getCause());
        } catch (Throwable ex) {
            throw new PegasusAirlinesServiceException("PegasusAirlinesService.findFlightById", ex);
        }
    }
}
