package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.PassengerService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/passenger")
@Scope("prototype")
public class PassengerController {
    private final PassengerService m_passengerService;

    public PassengerController(PassengerService passengerService) {
        m_passengerService = passengerService;
    }

    @PostMapping("/save")
    public PassengerResponseDTO savePassenger(@RequestBody PassengerRequestDTO passengerRequestDTO) throws Exception
    {
        return m_passengerService.savePassenger(passengerRequestDTO);
    }

    @GetMapping("/find/id")
    public PassengerResponseDTO findPassengerById(@RequestParam("id") Long passengerId) throws Exception {
        return m_passengerService.findPassengerById(passengerId);
    }

}
