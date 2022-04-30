package kaya.sengul.app.service.rest.ticketreservation.dto.requestDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TurkishAirlinesRequestDTO {
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

    public TurkishAirlinesRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public TurkishAirlinesRequestDTO setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public TurkishAirlinesRequestDTO setBaseFare(double baseFare) {
        this.baseFare = baseFare;
        return this;
    }

    public boolean isInternational() {
        return international;
    }

    public TurkishAirlinesRequestDTO setInternational(boolean international) {
        this.international = international;
        return this;
    }

    public String getCityOfDeparture() {
        return cityOfDeparture;
    }

    public TurkishAirlinesRequestDTO setCityOfDeparture(String cityOfDeparture) {
        this.cityOfDeparture = cityOfDeparture;
        return this;
    }

    public String getCityOfArrival() {
        return cityOfArrival;
    }

    public TurkishAirlinesRequestDTO setCityOfArrival(String cityOfArrival) {
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
