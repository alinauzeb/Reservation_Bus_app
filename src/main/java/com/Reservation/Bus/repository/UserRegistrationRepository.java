package com.Reservation.Bus.repository;

import com.Reservation.Bus.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {
}
