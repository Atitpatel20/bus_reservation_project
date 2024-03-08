package com.bus_reservation_project.service;

import com.bus_reservation_project.payload.BusDto;

import java.util.List;
import java.util.Optional;

public interface BusService {
    List<BusDto> getAllBuses();
    BusDto getBusById(Long id);
    BusDto addBus(BusDto busDTO);

    BusDto updateBus(Long id, BusDto busDTO);

    void deleteBus(Long id);
}


