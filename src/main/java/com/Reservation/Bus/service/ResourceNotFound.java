package com.Reservation.Bus.service;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String s) {
        super(s);
    }
}
