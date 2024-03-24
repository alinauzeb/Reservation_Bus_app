package com.Reservation.Bus.repository;

import com.Reservation.Bus.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    Route findByBusId(long busId);

    List<Route> findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate);

}
