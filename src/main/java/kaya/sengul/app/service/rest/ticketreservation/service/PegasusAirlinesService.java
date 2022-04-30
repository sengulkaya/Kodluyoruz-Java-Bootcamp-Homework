package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PegasusAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public PegasusAirlinesResponseDTO saveFlight(PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) throws Exception
    {
        return m_pegasusAirlinesConverter.toPegasusAirlinesFlightResponseDTO(m_serviceApplicationDAL.savePegasusAirlinesFlight
                (m_pegasusAirlinesConverter.toPegasusAirlines(pegasusAirlinesRequestDTO)));
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
