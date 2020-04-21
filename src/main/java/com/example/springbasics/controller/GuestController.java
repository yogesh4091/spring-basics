package com.example.demo.controller;

import com.example.demo.data.entity.Guest;
import com.example.demo.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {
  @Autowired private GuestRepository guestRepository;

  @RequestMapping(value = "/guests", method = RequestMethod.GET)
  public List<Guest> getGuests() {
    List<Guest> list = new ArrayList<>();
    guestRepository.findAll().forEach(list::add);
    return list;
  }

  @GetMapping(value = "/guestById")
  public Guest getGuestById(@RequestParam(required = false) Long guestId) {

    Optional<Guest> guest = guestRepository.findById(guestId);
    return guest.orElse(null);
  }
}
