package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TicketRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TicketResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.service.TicketService;
import org.springframework.context.annotation.Scope;
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

    @PostMapping("/reserve")
    public TicketResponseDTO reserveTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        return m_ticketService.reserveTurkishAirlinesTicket(ticketRequestDTO);
    }

    @GetMapping("/find")
    public List<TicketResponseDTO> findTicketsByPassengerId(@RequestParam Long passengerId) throws Exception {
        return m_ticketService.findTurkishAirlinesTicketByPassengerId(passengerId);
    }

    @GetMapping("/all")
    public List<TicketResponseDTO> findAllTickets() throws Exception {
        return m_ticketService.findTurkishAirlinesTickets();
    }
}
