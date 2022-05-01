package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.PegasusAirlinesService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flight/pegasusAirlines")
@Scope("prototype")
public class PegasusAirlinesController {
    private final PegasusAirlinesService m_pegasusAirlinesService;

    public PegasusAirlinesController(PegasusAirlinesService pegasusAirlinesService)
    {
        m_pegasusAirlinesService = pegasusAirlinesService;
    }

    @PostMapping("/save")
    public PegasusAirlinesResponseDTO saveFlight(@RequestBody PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) throws Exception {
        return m_pegasusAirlinesService.saveFlight(pegasusAirlinesRequestDTO);
    }

    @GetMapping("find/all")
    public List<PegasusAirlinesResponseDTO> findAllFlights() throws Exception {
        return m_pegasusAirlinesService.findPegasusAirlinesFlights();
    }

    @GetMapping("/find/id")
    public PegasusAirlinesResponseDTO findFlightById(@RequestParam("id") Long flightId) throws Exception {
        return m_pegasusAirlinesService.findFlightById(flightId);
    }

    @PostMapping("/update/{id}")
    public PegasusAirlinesResponseDTO updateFlight(@PathVariable("id") Long flightId, @RequestBody PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO)
    {
        return m_pegasusAirlinesService.updateFlight(flightId, pegasusAirlinesRequestDTO);
    }

    @PostMapping("/cancel/id")
    public PegasusAirlinesResponseDTO cancelFlight(@RequestParam("id") Long flightId) throws Exception {
        return m_pegasusAirlinesService.cancelFlight(flightId);
    }
}
