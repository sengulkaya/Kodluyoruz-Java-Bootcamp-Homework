package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PegasusAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.PegasusAirlinesService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PegasusAirlinesResponseDTO> saveFlight(@RequestBody PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO) {
        ResponseEntity<PegasusAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_pegasusAirlinesService.saveFlight(pegasusAirlinesRequestDTO));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("find/all")
    public ResponseEntity<List<PegasusAirlinesResponseDTO>> findAllFlights() {
        ResponseEntity<List<PegasusAirlinesResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_pegasusAirlinesService.findPegasusAirlinesFlights());
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/find/id")
    public ResponseEntity<PegasusAirlinesResponseDTO> findFlightById(@RequestParam("id") Long flightId) {
        ResponseEntity<PegasusAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_pegasusAirlinesService.findFlightById(flightId));
        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<PegasusAirlinesResponseDTO> updateFlight(@PathVariable("id") Long flightId, @RequestBody PegasusAirlinesRequestDTO pegasusAirlinesRequestDTO)
    {
        ResponseEntity<PegasusAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_pegasusAirlinesService.updateFlight(flightId, pegasusAirlinesRequestDTO));
        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/cancel/id")
    public ResponseEntity<PegasusAirlinesResponseDTO> cancelFlight(@RequestParam("id") Long flightId) throws Exception {
        ResponseEntity<PegasusAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_pegasusAirlinesService.cancelFlight(flightId));
        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
