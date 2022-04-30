package kaya.sengul.app.service.rest.ticketreservation.controller;

import kaya.sengul.app.service.rest.ticketreservation.service.PegasusAirlinesService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flight/pegasusAirlines")
@Scope("prototype")
public class PegasusAirlinesController {
    private final PegasusAirlinesService m_pegasusAirlinesService;

    public PegasusAirlinesController(PegasusAirlinesService pegasusAirlinesService)
    {
        m_pegasusAirlinesService = pegasusAirlinesService;
    }
}
