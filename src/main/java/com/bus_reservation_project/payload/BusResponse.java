package com.bus_reservation_project.payload;

public class BusResponse {
    private BusDto busDto;
    private String message;

    // Constructors, getters, and setters

    public BusResponse(BusDto busDto, String message) {
        this.busDto = busDto;
        this.message = message;
    }

    public BusDto getBusDto() {
        return busDto;
    }

    public void setBusDto(BusDto busDto) {
        this.busDto = busDto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

