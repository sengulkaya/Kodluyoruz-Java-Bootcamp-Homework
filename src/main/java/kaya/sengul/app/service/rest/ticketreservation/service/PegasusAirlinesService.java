package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PegasusAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.PegasusAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
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

    public PegasusAirlinesResponseDTO cancelFlight(Long flightId) throws Exception //new
    {
        PegasusAirlines pegasusAirlines = m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId);
        m_serviceApplicationDAL.cancelPegasusAirlinesFlight(pegasusAirlines);
        return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(pegasusAirlines);

    }

    public PegasusAirlinesResponseDTO saveFlight(PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) throws Exception
    {
        return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(m_serviceApplicationDAL.savePegasusAirlinesFlight
                (m_pegasusAirlinesConverter.toPegasusAirlines(pegasusAirlinesRequestDTO)));
    }

    @Transactional
    public PegasusAirlinesResponseDTO updateFlight(Long flightId, PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) {

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
    }

    public List<PegasusAirlinesResponseDTO> findPegasusAirlinesFlights()
    {
        return StreamSupport.stream(m_serviceApplicationDAL.findPegasusAirlinesFlights().spliterator(), false)
                .map(m_pegasusAirlinesConverter :: toPegasusAirlinesFlightResponseDTO)
                .collect(Collectors.toList());

    }

    public PegasusAirlinesResponseDTO findFlightById(Long flightId)
    {
        return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(
                (m_serviceApplicationDAL.findPegasusAirlinesFlightById(flightId)));

    }
}
