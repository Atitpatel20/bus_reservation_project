package com.bus_reservation_project.service.Impl;

import com.bus_reservation_project.entity.Bus;
import com.bus_reservation_project.entity.Route;
import com.bus_reservation_project.exception.ResourceNotFoundException;
import com.bus_reservation_project.payload.RouteDTO;
import com.bus_reservation_project.respositary.BusRepository;
import com.bus_reservation_project.respositary.RouteRepository;
import com.bus_reservation_project.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RouteDTO> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RouteDTO> getRouteById(Long id) {
        Optional<Route> routeOptional = routeRepository.findById(id);
        return routeOptional.map(this::mapToDto);
    }

    @Override
    @Transactional
    public RouteDTO addRoute(RouteDTO routeDTO) {
        Long busId = routeDTO.getBusId();
        Optional<Bus> busOptional = busRepository.findById(busId);

        // Check if bus is present
        if (busOptional.isEmpty()) {
            throw new ResourceNotFoundException("Bus not added.");
        }

        // Check if route already exists
        Optional<Route> existingRoute = routeRepository.findByBusId(busId);
        if (existingRoute.isPresent()) {
            throw new IllegalStateException("Route already added.");
        }

        Route route = mapToEntity(routeDTO);
        Route savedRoute = routeRepository.save(route);
        return mapToDto(savedRoute);
    }

    @Override
    public void deleteRoute(Long id) {
        // Check if the route exists
        Optional<Route> routeOptional = routeRepository.findById(id);
        if (routeOptional.isEmpty()) {
            throw new ResourceNotFoundException("Route with ID " + id + " not found.");
        }

        // Delete the route
        routeRepository.deleteById(id);
    }

    @Override
    public RouteDTO updateRoute(Long id, RouteDTO routeDTO) {
        // Check if the route exists
        Optional<Route> routeOptional = routeRepository.findById(id);
        if (routeOptional.isEmpty()) {
            throw new ResourceNotFoundException("Route with ID " + id + " not found.");
        }

        // Get the existing route
        Route route = routeOptional.get();

        // Update fields from routeDTO to route entity
        route.setFromLocation(routeDTO.getFromLocation());
        route.setToLocation(routeDTO.getToLocation());
        route.setFromDate(routeDTO.getFromDate());
        route.setToDate(routeDTO.getToDate());
        route.setTotalDuration(routeDTO.getTotalDuration());
        route.setFromTime(routeDTO.getFromTime());
        route.setToTime(routeDTO.getToTime());

        // Save the updated route
        Route updatedRoute = routeRepository.save(route);

        return mapToDto(updatedRoute);
    }


    private RouteDTO mapToDto(Route route) {
        return modelMapper.map(route, RouteDTO.class);
    }

    private Route mapToEntity(RouteDTO routeDTO) {
        return modelMapper.map(routeDTO, Route.class);
    }
}

