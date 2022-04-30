package kaya.sengul.app.service.rest.ticketreservation.controller;
import kaya.sengul.app.service.rest.ticketreservation.converter.PegasusAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.TurkishAirlinesService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("api/flight/turkishAirlines")
@Scope("prototype")
public class TurkishAirlinesController {
    private final TurkishAirlinesService m_turkishAirlinesService;

    public TurkishAirlinesController(TurkishAirlinesService turkishAirlinesService)
    {
        m_turkishAirlinesService = turkishAirlinesService;
    }

    @GetMapping("find/all")
    public List<TurkishAirlinesResponseDTO> findAllFlights() throws Exception {
        return m_turkishAirlinesService.findTurkishAirlinesFlights();
    }

    @GetMapping("/find/id")
    public TurkishAirlinesResponseDTO findFlightById(@RequestParam("id") Long flightId) throws Exception {
        return m_turkishAirlinesService.findFlightById(flightId);
    }

    @PostMapping("/save")
    public TurkishAirlinesResponseDTO saveFlight(@RequestBody TurkishAirlinesRequestDTO turkishAirlinesRequestDTO) throws Exception {
        return m_turkishAirlinesService.saveFlight(turkishAirlinesRequestDTO);
    }

    /*@PostMapping("/update")
    public TurkishAirlinesResponseDTO updateFlight(@RequestBody TurkishAirlinesRequestDTO turkishAirlinesRequestDTO) throws Exception {
        return m_turkishAirlinesService.updateFlight(turkishAirlinesRequestDTO);
    }*/


}
