package com.bus_reservation_project.service;

import com.bus_reservation_project.payload.RouteDTO;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    List<RouteDTO> getAllRoutes();
    Optional<RouteDTO> getRouteById(Long id);
    RouteDTO addRoute(RouteDTO routeDTO);

    void deleteRoute(Long id);

    RouteDTO updateRoute(Long id, RouteDTO routeDTO);
}
