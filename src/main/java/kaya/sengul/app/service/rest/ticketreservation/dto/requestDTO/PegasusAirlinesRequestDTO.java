package kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PegasusAirlinesRequestDTO {
    private String name;
    private int capacity;
    private double baseFare;
    private boolean international;
    private String cityOfDeparture;
    private String cityOfArrival;
    //private LocalDate departureTime;

    public String getName() {
        return name;
    }

    public PegasusAirlinesRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public PegasusAirlinesRequestDTO setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public PegasusAirlinesRequestDTO setBaseFare(double baseFare) {
        this.baseFare = baseFare;
        return this;
    }

    public boolean isInternational() {
        return international;
    }

    public PegasusAirlinesRequestDTO setInternational(boolean international) {
        this.international = international;
        return this;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public PegasusAirlinesRequestDTO setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public PegasusAirlinesRequestDTO setCityOfArrival(String cityOfArrival) {
        this.cityOfArrival = cityOfArrival;
        return this;
    }

    /*public LocalDate getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }*/
}
