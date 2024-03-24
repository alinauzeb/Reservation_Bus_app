package com.Reservation.Bus.service;
import com.Reservation.Bus.entity.Bus;
import com.Reservation.Bus.payload.BusDto;
import com.Reservation.Bus.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Bus addBus(BusDto busDto) {

        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        Bus savedBus = busRepository.save(bus);

        return savedBus;

            }
        }

