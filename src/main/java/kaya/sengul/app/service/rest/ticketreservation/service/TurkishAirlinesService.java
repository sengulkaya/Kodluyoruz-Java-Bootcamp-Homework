package kaya.sengul.app.service.rest.ticketreservation.service;


import kaya.sengul.app.service.rest.ticketreservation.converter.TurkishAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.flight.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.repository.RepositoryException;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.service.TurkishAirlinesServiceException;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TurkishAirlinesService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final TurkishAirlinesConverter m_turkishAirlinesConverter;

    public TurkishAirlinesService(ServiceApplicationDAL serviceApplicationDAL, TurkishAirlinesConverter converter)
    {
        m_serviceApplicationDAL = serviceApplicationDAL;
        m_turkishAirlinesConverter = converter;
    }


    public TurkishAirlinesResponseDTO saveFlight(TurkishAirlinesRequestDTO turkishAirlinesRequestDTO) throws Exception
    {
        try {
            return m_turkishAirlinesConverter.toTurkishAirlinesFlightResponseDTO(m_serviceApplicationDAL.saveTurkishAirlinesFlight
                    (m_turkishAirlinesConverter.toTurkishAirlines(turkishAirlinesRequestDTO)));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.saveFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.saveFlight", ex);
        }
    }

    @Transactional
    public TurkishAirlinesResponseDTO updateFlight(Long flightId, TurkishAirlinesRequestDTO turkishAirlinesRequestDTO) {
        try {
            TurkishAirlines flight = m_serviceApplicationDAL.findTurkishAirlinesFlightById(flightId);

            flight.setName(turkishAirlinesRequestDTO.getName())
                    .setCapacity(turkishAirlinesRequestDTO.getCapacity())
                    .setBaseFare(turkishAirlinesRequestDTO.getBaseFare())
                    .setInternational(turkishAirlinesRequestDTO.isInternational())
                    .setCityOfDeparture(turkishAirlinesRequestDTO.getCityOfDeparture())
                    .setCityOfArrival(turkishAirlinesRequestDTO.getCityOfArrival());

            Set<Ticket> flightTickets = flight.getTickets();
            for (var ticket : flightTickets) {
                ticket.setInternational(flight.isInternational())
                        .setCityOfDeparture(flight.getCityOfDeparture())
                        .setCityOfArrival(flight.getCityOfArrival())
                        .setFare(flight.getBaseFare());
            }

            flight.setTickets(flightTickets);

            return m_turkishAirlinesConverter.toTurkishAirlinesFlightResponseDTO
                    (m_serviceApplicationDAL.saveTurkishAirlinesFlight(flight));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.updateFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.updateFlight", ex);
        }
    }

    public TurkishAirlinesResponseDTO cancelFlight(Long flightId) throws Exception //new
    {
        try {
            TurkishAirlines turkishAirlines = m_serviceApplicationDAL.findTurkishAirlinesFlightById(flightId);
            m_serviceApplicationDAL.cancelTurkishAirlinesFlight(turkishAirlines);
            return m_turkishAirlinesConverter.toTurkishAirlinesFlightResponseDTO(turkishAirlines);
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.cancelFlight", ex.getCause());
        } catch (Throwable ex) {
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.cancelFlight", ex);
        }
    }

    public TurkishAirlinesResponseDTO findFlightById(Long flightId)
    {
        try {
            return m_turkishAirlinesConverter.toTurkishAirlinesFlightResponseDTO
                    (m_serviceApplicationDAL.findTurkishAirlinesFlightById(flightId));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.findFlightById", ex.getCause());
        } catch (Throwable ex) {
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.findFlightById", ex);
        }
    }

    public List<TurkishAirlinesResponseDTO> findTurkishAirlinesFlights()
    {
        try {
            return StreamSupport.stream(m_serviceApplicationDAL.findTurkishAirlinesFlights().spliterator(), false)
                    .map(m_turkishAirlinesConverter :: toTurkishAirlinesFlightResponseDTO)
                    .collect(Collectors.toList());
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.findTurkishAirlinesFlights", ex.getCause());
        } catch (Throwable ex) {
            throw new TurkishAirlinesServiceException("TurkishAirlinesService.findTurkishAirlinesFlights", ex);
        }
    }
}
