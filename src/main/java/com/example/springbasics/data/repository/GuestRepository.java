package com.example.springbasics.data.repository;

import com.example.springbasics.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository
    extends CrudRepository<Guest, Long>, QueryByExampleExecutor<Guest> {}
