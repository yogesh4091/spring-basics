package com.example.springbasics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GuestFilterQuery {

  private final GuestDto guest;
  private final int size;
  private final int offset;
  private final SortBy sortBy;
}
