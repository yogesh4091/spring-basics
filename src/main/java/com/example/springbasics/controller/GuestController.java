package com.example.springbasics.controller;

import com.example.springbasics.data.entity.Guest;
import com.example.springbasics.data.repository.GuestRepository;
import com.example.springbasics.dto.GuestDto;
import com.example.springbasics.dto.GuestFilterQuery;
import com.example.springbasics.dto.SortBy;
import com.example.springbasics.services.GuestFilterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

  private final GuestRepository guestRepository;
  private final GuestFilterService guestFilterService;

  @Autowired
  public GuestController(GuestRepository guestRepository, GuestFilterService guestFilterService) {
    this.guestRepository = guestRepository;
    this.guestFilterService = guestFilterService;
  }

  @GetMapping(value = "/guests")
  public List<Guest> getGuests() {
    List<Guest> list = new ArrayList<>();
    guestRepository.findAll().forEach(list::add);
    return list;
  }

  @PostMapping(value = "/guest")
  public Guest saveGuest(GuestDto guestDto) {
    return guestFilterService.createGuest(guestDto);
  }

  @GetMapping(value = "/guestById")
  public Guest getGuestById(@RequestParam(required = false) Long guestId) {

    Optional<Guest> guest = guestRepository.findById(guestId);
    return guest.orElse(null);
  }

  @PostMapping(value = "/searchGuestList")
  public List<Guest> searchGuestList(
      // using DTO object since Entity should not be shared with outside world.
      @RequestBody GuestDto guest,
      // We could use default page size here.
      @RequestParam(required = false, defaultValue = "2") int pageSize,
      // default offset could be zero.
      @RequestParam(required = false, defaultValue = "0") int offSet,
      // Sort by Enum
      @RequestParam SortBy sortBy) {

    // Only query or command objects should be passed to Service class.
    GuestFilterQuery guestFilterQuery =
        GuestFilterQuery.builder()
            .guest(guest)
            .offset(offSet)
            .size(pageSize)
            .sortBy(sortBy)
            .build();
    return guestFilterService.filteredGuestList(guestFilterQuery);
  }
}
