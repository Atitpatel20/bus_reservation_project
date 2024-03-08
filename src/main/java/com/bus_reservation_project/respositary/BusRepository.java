package com.bus_reservation_project.respositary;

import com.bus_reservation_project.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
