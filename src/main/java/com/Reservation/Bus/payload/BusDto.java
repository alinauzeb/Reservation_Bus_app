package com.Reservation.Bus.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private long id;
    private String busNumber;
    private String busType;
    private double  price;
    private int totalSeats;
    private int  availableSeats;
}
