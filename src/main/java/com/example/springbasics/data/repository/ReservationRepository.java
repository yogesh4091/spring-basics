package com.example.springbasics.data.repository;

import com.example.springbasics.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
