package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PegasusAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.TicketService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/ticket")
@Scope("prototype")
public class TicketController {
    private final TicketService m_ticketService;
    public TicketController(TicketService ticketService)
    {
        m_ticketService = ticketService;
    }


    @PostMapping("/TurkishAirlines/reserve")
    public ResponseEntity<TicketResponseDTO> reserveTurkishAirlinesTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        ResponseEntity<TicketResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.reserveTurkishAirlinesTicket(ticketRequestDTO));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @GetMapping("/TurkishAirlines/tickets/all")
    public ResponseEntity<List<TicketResponseDTO>> findTurkishAirlinesTickets() throws Exception {
        ResponseEntity<List<TicketResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.findTurkishAirlinesTickets());
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }
    @PostMapping("/TurkishAirlines/cancel/id")
    public ResponseEntity<TicketResponseDTO> cancelTurkishAirlinesTicket(@RequestParam("id") Long ticketId) throws Exception {
        ResponseEntity<TicketResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.cancelTurkishAirlinesTicket(ticketId));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }


    @PostMapping("/PegasusAirlines/reserve")//ok
    public ResponseEntity<TicketResponseDTO> reservePegasusAirlinesTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        ResponseEntity<TicketResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.reservePegasusAirlinesTicket(ticketRequestDTO));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @GetMapping("/PegasusAirlines/tickets/all")
    public ResponseEntity<List<TicketResponseDTO>> findPegasusAirlinesTickets() {
        ResponseEntity<List<TicketResponseDTO>> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.findPegasusAirlinesTickets());
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    @PostMapping("/PegasusAirlines/cancel/id")
    public ResponseEntity<TicketResponseDTO> cancelPegasusAirlinesTicket(@RequestParam("id") Long ticketId) {
        ResponseEntity<TicketResponseDTO> responseEntity = ResponseEntity.badRequest().build();

        try {
            responseEntity = ResponseEntity.ok(m_ticketService.cancelPegasusAirlinesTicket(ticketId));
        }
        catch (Throwable ex) {
            System.out.printf("%s: %s", ex.getMessage(), ex.getCause());
        }
        return responseEntity;
    }

    //passengerId is transiet in tickets table so it is not serializable and stored in db
    //I can not make any search by using it!
    /*@GetMapping("/TurkishAirlines/tickets/find/passengerId")
    public List<TicketResponseDTO> findTurkishAirlinesTicketByPassengerId(@RequestParam Long passengerId) throws Exception {
        return m_ticketService.findTurkishAirlinesTicketByPassengerId(passengerId);
    }*/

    /*@GetMapping("/PegasusAirlines/tickets/find/passengerId")
    public List<TicketResponseDTO> findPegasusAirlinesTicketByPassenger(@RequestParam Long passengerId) throws Exception {
        return m_ticketService.findPegasusAirlinesTicketByPassengerId(passengerId);
    }*/

}
