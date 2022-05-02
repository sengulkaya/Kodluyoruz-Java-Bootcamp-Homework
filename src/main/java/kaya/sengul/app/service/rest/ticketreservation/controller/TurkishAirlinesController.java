package kaya.sengul.app.service.rest.ticketreservation.controller;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.TurkishAirlinesService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/flight/turkishAirlines")
@Scope("prototype")
public class TurkishAirlinesController {
    private final TurkishAirlinesService m_turkishAirlinesService;

    public TurkishAirlinesController(TurkishAirlinesService turkishAirlinesService)
    {
        m_turkishAirlinesService = turkishAirlinesService;
    }

    @PostMapping("/save")
    public ResponseEntity<TurkishAirlinesResponseDTO> saveFlight(@RequestBody TurkishAirlinesRequestDTO turkishAirlinesRequestDTO) {
        ResponseEntity<TurkishAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_turkishAirlinesService.saveFlight(turkishAirlinesRequestDTO));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("find/all")
    public ResponseEntity<List<TurkishAirlinesResponseDTO>> findAllFlights() {
        ResponseEntity<List<TurkishAirlinesResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_turkishAirlinesService.findTurkishAirlinesFlights());
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/find/id")
    public ResponseEntity<TurkishAirlinesResponseDTO> findFlightById(@RequestParam("id") Long flightId) {
        ResponseEntity<TurkishAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_turkishAirlinesService.findFlightById(flightId));
        } catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TurkishAirlinesResponseDTO>  updateFlight(@PathVariable("id") Long flightId, @RequestBody TurkishAirlinesRequestDTO turkishAirlinesRequestDTO)
    {
        ResponseEntity<TurkishAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_turkishAirlinesService.updateFlight(flightId, turkishAirlinesRequestDTO));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/cancel/id")
    public ResponseEntity<TurkishAirlinesResponseDTO> cancelFlight(@RequestParam("id") Long flightId) throws Exception {
        ResponseEntity<TurkishAirlinesResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_turkishAirlinesService.cancelFlight(flightId));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
}
