package com.bus_reservation_project.controller;

import com.bus_reservation_project.payload.BusDto;
import com.bus_reservation_project.payload.BusResponse;
import com.bus_reservation_project.payload.BusesWithMessageResponse;
import com.bus_reservation_project.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buses")
public class BusController {
    @Autowired
    private BusService busService;

//    @GetMapping
//    public ResponseEntity<List<BusDto>> getAllBuses() {
//        List<BusDto> buses = busService.getAllBuses();
//        return new ResponseEntity<>(buses, HttpStatus.OK);
//    }
@GetMapping
public ResponseEntity<BusesWithMessageResponse> getAllBuses() {
    List<BusDto> buses = busService.getAllBuses();
    String message = "All buses have been retrieved successfully.";
    BusesWithMessageResponse response = new BusesWithMessageResponse(buses, message);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable Long id) {
        BusDto bus = busService.getBusById(id);
        return new ResponseEntity<>(bus,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BusResponse> addBus(@RequestBody BusDto busDTO) {
        BusDto addedBus = busService.addBus(busDTO);
        String message = "Bus added successfully";
        BusResponse response = new BusResponse(addedBus, message);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusResponse> updateBus(@PathVariable Long id, @RequestBody BusDto busDTO) {
        BusDto updatedBus = busService.updateBus(id, busDTO);
        String message = "Bus updated successfully";
        BusResponse response = new BusResponse(updatedBus, message);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return new ResponseEntity<>("Bus delete successfully", HttpStatus.OK);
    }
}
