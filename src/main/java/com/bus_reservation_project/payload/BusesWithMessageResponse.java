package com.bus_reservation_project.payload;

import java.util.List;

public class BusesWithMessageResponse {
    private List<BusDto> buses;
    private String message;

    // Constructors, getters, and setters

    public BusesWithMessageResponse(List<BusDto> buses, String message) {
        this.buses = buses;
        this.message = message;
    }

    // Getters and setters

    public List<BusDto> getBuses() {
        return buses;
    }

    public void setBuses(List<BusDto> buses) {
        this.buses = buses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
