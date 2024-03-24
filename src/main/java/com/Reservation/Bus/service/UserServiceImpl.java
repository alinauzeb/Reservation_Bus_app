package com.Reservation.Bus.service;

import com.Reservation.Bus.entity.UserRegistration;
import com.Reservation.Bus.payload.UserRegistrationDto;
import com.Reservation.Bus.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRegistrationRepository.save(userRegistration);
        return null;
    }

    public UserRegistration getDatById(long id) {
        UserRegistration userRegistration = userRegistrationRepository.findById(id).get();
       return userRegistration;
    }
}
