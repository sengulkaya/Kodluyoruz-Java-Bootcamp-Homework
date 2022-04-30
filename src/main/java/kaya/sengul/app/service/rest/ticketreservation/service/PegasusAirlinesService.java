package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PegasusAirlinesConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import org.springframework.stereotype.Service;

@Service
public class PegasusAirlinesService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final PegasusAirlinesConverter m_pegasusAirlinesConverter;

    public PegasusAirlinesService(ServiceApplicationDAL serviceApplicationDAL, PegasusAirlinesConverter converter)
    {
        m_serviceApplicationDAL = serviceApplicationDAL;
        m_pegasusAirlinesConverter = converter;
    }
}
