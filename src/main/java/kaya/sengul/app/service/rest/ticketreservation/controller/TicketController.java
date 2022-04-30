package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.data.entity.ticket.Ticket;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
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


    @PostMapping("/TurkishAirlines/reserve")
    public TicketResponseDTO reserveTurkishAirlinesTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        return m_ticketService.reserveTurkishAirlinesTicket(ticketRequestDTO);
    }
    @GetMapping("/TurkishAirlines/tickets/all")
    public List<TicketResponseDTO> findTurkishAirlinesTickets() throws Exception {
        return m_ticketService.findTurkishAirlinesTickets();
    }

    //passengerId is transiet in tickets table so it is not serializable and stored in db
    //I can not make any search by using it!
    /*@GetMapping("/TurkishAirlines/tickets/find/passengerId")
    public List<TicketResponseDTO> findTurkishAirlinesTicketByPassengerId(@RequestParam Long passengerId) throws Exception {
        return m_ticketService.findTurkishAirlinesTicketByPassengerId(passengerId);
    }*/


    @PostMapping("/PegasusAirlines/reserve")//ok
    public TicketResponseDTO reservePegasusAirlinesTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        return m_ticketService.reservePegasusAirlinesTicket(ticketRequestDTO);
    }

    @GetMapping("/PegasusAirlines/tickets/all")//ok
    public List<TicketResponseDTO> findPegasusAirlinesTickets() throws Exception {
        return m_ticketService.findPegasusAirlinesTickets();
    }

    /*@GetMapping("/PegasusAirlines/tickets/find/passengerId")
    public List<TicketResponseDTO> findPegasusAirlinesTicketByPassenger(@RequestParam Long passengerId) throws Exception {
        return m_ticketService.findPegasusAirlinesTicketByPassengerId(passengerId);
    }*/

}
