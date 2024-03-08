package com.bus_reservation_project.respositary;

import com.bus_reservation_project.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route,Long> {
    Optional<Route> findByBusId(Long busId);
}
