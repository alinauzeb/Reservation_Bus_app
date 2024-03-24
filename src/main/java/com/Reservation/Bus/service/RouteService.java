package com.Reservation.Bus.service;

import com.Reservation.Bus.entity.Bus;
import com.Reservation.Bus.entity.Route;
import com.Reservation.Bus.repository.BusRepository;
import com.Reservation.Bus.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;

    public Route createRoute(long busId, Route route) {
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not add!!")

        );
        route.setBusId(busId);
        Route save = routeRepository.save(route);
        return save;

    }
}
