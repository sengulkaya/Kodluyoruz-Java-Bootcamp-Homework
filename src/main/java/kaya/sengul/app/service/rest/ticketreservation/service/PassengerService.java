package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PassengerConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Adult;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.plane.TurkishAirlines;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.TurkishAirlinesRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.TurkishAirlinesResponseDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassengerService {
    private ServiceApplicationDAL m_serviceApplicationDAL;
    private PassengerConverter m_passengerConverter;

    public PassengerService(ServiceApplicationDAL m_serviceApplicationDAL, PassengerConverter m_passengerConverter) {
        this.m_serviceApplicationDAL = m_serviceApplicationDAL;
        this.m_passengerConverter = m_passengerConverter;
    }

    public PassengerResponseDTO savePassenger(PassengerRequestDTO passengerRequestDTO) throws Exception
    {

        Passenger passenger = null;
        if (passengerRequestDTO.getAge() > 18) {//this can expand with various other conditions
            passenger = new Adult();
        } else {
            throw new IllegalArgumentException("No passenger under the age of 18!");
        }
        passenger.setName(passengerRequestDTO.getName());
        passenger.setAge(passengerRequestDTO.getAge());

        return m_passengerConverter.toPassengerResponseDTO(m_serviceApplicationDAL.savePassenger(passenger));
    }

    public PassengerResponseDTO findPassengerById(Long passengerId)
    {
        return m_passengerConverter.toPassengerResponseDTO(m_serviceApplicationDAL.findPassengerById(passengerId));

    }
}
