package com.Reservation.Bus.controller;

import com.Reservation.Bus.entity.Route;
import com.Reservation.Bus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    //http://localhost:8080/api/v1/route/add/1
    @PostMapping("add/{busId}")
    public ResponseEntity<Route> addRoute(@PathVariable long busId, @RequestBody Route route){
        Route r = routeService.createRoute(busId, route);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }
}
