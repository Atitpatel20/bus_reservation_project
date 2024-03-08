package com.bus_reservation_project.controller;

import com.bus_reservation_project.payload.RouteDTO;
import com.bus_reservation_project.payload.RouteResponse;
import com.bus_reservation_project.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

@GetMapping
public ResponseEntity<RouteResponse> getAllRoutes() {
    List<RouteDTO> routes = routeService.getAllRoutes();
    String message = "All routes have been retrieved successfully.";
    RouteResponse response = new RouteResponse(routes, message);
    return new ResponseEntity<>(response, HttpStatus.OK);
}
    @GetMapping("/{id}")
    public ResponseEntity<RouteDTO> getRouteById(@PathVariable Long id) {
        Optional<RouteDTO> route = routeService.getRouteById(id);
        return route.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<RouteDTO> addRoute(@RequestBody RouteDTO routeDTO) {
        RouteDTO addedRoute = routeService.addRoute(routeDTO);
        return new ResponseEntity<>(addedRoute, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return new ResponseEntity<>("Route with ID " + id + " has been deleted successfully.", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RouteDTO> updateRoute(@PathVariable Long id, @RequestBody RouteDTO routeDTO) {
        RouteDTO updatedRoute = routeService.updateRoute(id, routeDTO);
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

}
