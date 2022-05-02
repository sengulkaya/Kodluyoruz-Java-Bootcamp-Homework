package kaya.sengul.app.service.rest.ticketreservation.service;

import kaya.sengul.app.service.rest.ticketreservation.converter.PassengerConverter;
import kaya.sengul.app.service.rest.ticketreservation.data.dal.ServiceApplicationDAL;
import kaya.sengul.app.service.rest.ticketreservation.data.entity.passenger.Passenger;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.repository.RepositoryException;
import kaya.sengul.app.service.rest.ticketreservation.dto.exception.service.PassengerServiceException;
import kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO.PassengerRequestDTO;
import kaya.sengul.app.service.rest.ticketreservation.dto.responseDTO.PassengerResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private final ServiceApplicationDAL m_serviceApplicationDAL;
    private final PassengerConverter m_passengerConverter;

    public PassengerService(ServiceApplicationDAL m_serviceApplicationDAL, PassengerConverter m_passengerConverter) {
        this.m_serviceApplicationDAL = m_serviceApplicationDAL;
        this.m_passengerConverter = m_passengerConverter;
    }

    public PassengerResponseDTO savePassenger(PassengerRequestDTO passengerRequestDTO) throws Exception
    {
        Passenger passenger = null;
        try {
            if (passengerRequestDTO.getAge() < 18) //this can expand with various other conditions
                throw new IllegalArgumentException("No passenger under the age of 18!");

            passenger.setName(passengerRequestDTO.getName());
            passenger.setAge(passengerRequestDTO.getAge());

            return m_passengerConverter.toPassengerResponseDTO(m_serviceApplicationDAL.savePassenger(passenger));

        } catch (IllegalArgumentException | RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PassengerServiceException("PassengerService.savePassenger", ex.getCause());
        } catch (Throwable ex) {
            throw new PassengerServiceException("PassengerService.savePassenger", ex);
        }
    }

    public PassengerResponseDTO findPassengerById(Long passengerId)
    {
        try {
            return m_passengerConverter.toPassengerResponseDTO(m_serviceApplicationDAL.findPassengerById(passengerId));
        } catch (RepositoryException ex) {
            System.out.printf("%s: %s",ex.getCause(), ex.getMessage());
            throw new PassengerServiceException("PassengerService.findPassengerById", ex.getCause());
        } catch (Throwable ex) {
            throw new PassengerServiceException("PassengerService.findPassengerById", ex);
        }
    }
}
