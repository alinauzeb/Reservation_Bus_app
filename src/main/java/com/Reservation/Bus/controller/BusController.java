package com.Reservation.Bus.controller;



import com.Reservation.Bus.entity.Bus;
import com.Reservation.Bus.entity.Route;
import com.Reservation.Bus.payload.BusDto;
import com.Reservation.Bus.payload.SearchListOfBusesDto;
import com.Reservation.Bus.repository.BusRepository;
import com.Reservation.Bus.repository.RouteRepository;
import com.Reservation.Bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;


    //http://localhost:8080/api/v1/bus/add

    @PostMapping("/add")
    public ResponseEntity<Bus>addBus(@RequestBody BusDto busDto){

        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/bus?fromLocation=Amazone&toLocation=India&fromDate=23/08/1817
    //http://localhost:8080/get?fromLocation=&toLocation=&fromDate
    //
@GetMapping("/SearchListOfBuses")
public  ResponseEntity<List<SearchListOfBusesDto>> getAllBuses(
        @RequestParam String fromLocation,
        @RequestParam String toLocation,
        @RequestParam String fromDate
) {
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SearchListOfBusesDto> buses = new ArrayList<>();
        for (Route route : routes) {
            Bus bus = busRepository.findById(route.getBusId()).get();
            SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBuses(bus, route);
            buses.add(searchListOfBusesDto);
        }
//        return new ResponseEntity<>(routes , HttpStatus.CREATED);
        return new ResponseEntity<>(buses,HttpStatus.OK);
    }
    SearchListOfBusesDto mapToSearchListOfBuses(Bus bus, Route route){
        SearchListOfBusesDto searchListOfBusesDto= new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());

        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToTime(route.getToTime());

        return searchListOfBusesDto;

















    }
}