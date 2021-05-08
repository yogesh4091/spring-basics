package com.example.springbasics.dto;

import lombok.Data;

@Data
public class GuestDto {
  private Long guestId;

  private String firstName;

  private String lastName;

  private String emailAddress;

  private String address;

  private String country;

  private String state;

  private String phoneNumber;
}
