package com.example.springbasics.data.repository;

import com.example.springbasics.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
