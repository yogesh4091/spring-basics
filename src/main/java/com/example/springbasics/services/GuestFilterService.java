package com.example.springbasics.services;

import com.example.springbasics.data.entity.Guest;
import com.example.springbasics.data.repository.GuestRepository;
import com.example.springbasics.dto.GuestDto;
import com.example.springbasics.dto.GuestFilterQuery;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GuestFilterService {

  @NonNull private final GuestRepository guestRepository;

  public Guest createGuest(GuestDto guestDto) {
    Guest guest = new Guest();
    // Using BeanUtils to copy guestDto into Guest
    BeanUtils.copyProperties(guestDto, guest);
    return guestRepository.save(guest);
  }

  public List<Guest> filteredGuestList(GuestFilterQuery guestFilterQuery) {

    Guest guest = new Guest();
    // Using BeanUtils to copy guestDto into Guest
    BeanUtils.copyProperties(guestFilterQuery.getGuest(), guest);
    Example<Guest> guestExample = Example.of(guest);

    Sort sortByField = Sort.by(guestFilterQuery.getSortBy().getQueryName());
    PageRequest pageRequest =
        PageRequest.of(guestFilterQuery.getOffset(), guestFilterQuery.getSize(), sortByField);
    return guestRepository.findAll(guestExample, pageRequest).toList();
  }
}
