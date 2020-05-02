package com.example.springbasics.controller;

import com.example.springbasics.data.entity.Guest;
import com.example.springbasics.data.repository.GuestRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Api(description = "CRUD Apis for Guest")
public class GuestController {
  @Autowired private GuestRepository guestRepository;

  @RequestMapping(value = "/guests", method = RequestMethod.GET)
  @ApiIgnore
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
