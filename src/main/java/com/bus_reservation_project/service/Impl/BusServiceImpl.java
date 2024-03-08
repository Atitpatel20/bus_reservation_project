package com.bus_reservation_project.service.Impl;

import com.bus_reservation_project.entity.Bus;
import com.bus_reservation_project.exception.ResourceNotFoundException;
import com.bus_reservation_project.payload.BusDto;
import com.bus_reservation_project.respositary.BusRepository;
import com.bus_reservation_project.service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BusDto> getAllBuses() {
        List<Bus> buses = busRepository.findAll();
        return buses.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bus with ID" + id + " not found.")
        );

        return mapToDto(bus);
    }
    @Override
    public BusDto updateBus(Long id, BusDto busDTO)  {
        Optional<Bus> optionalBus = busRepository.findById(id);
        if (optionalBus.isPresent()) {
            // Update properties of existingBus with properties from busDTO
            Bus existingBus = optionalBus.get();
            existingBus.setBusType(busDTO.getBusType());
            existingBus.setBusNumber(busDTO.getBusNumber());
            existingBus.setPrice(busDTO.getPrice());
            existingBus.setTotalSeats(busDTO.getTotalSeats());
            existingBus.setAvailableSeats(busDTO.getAvailableSeats());

            Bus updateBus = busRepository.save(existingBus);
            return mapToDto(updateBus);
        } else {
            throw new ResourceNotFoundException("Bus with id " + id + " not found");
        }
    }

    @Override
    public void deleteBus(Long id)  {
        Optional<Bus> optionalBus = busRepository.findById(id);
        if (optionalBus.isPresent()) {
            busRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Bus with id " + id + " not found");
        }
    }

    @Override
    public BusDto addBus(BusDto busDTO) {
        Bus bus = mapToEntity(busDTO);
        Bus savedBus = busRepository.save(bus);
        return mapToDto(savedBus);
    }

    private BusDto mapToDto(Bus bus) {
        return modelMapper.map(bus, BusDto.class);
    }

    private Bus mapToEntity(BusDto busDTO) {
        return modelMapper.map(busDTO, Bus.class);
    }
}

