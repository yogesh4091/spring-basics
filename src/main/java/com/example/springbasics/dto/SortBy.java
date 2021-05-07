package com.example.springbasics.dto;

import lombok.Getter;

@Getter
public enum SortBy {
  FIRST_NAME("firstName"),
  LAST_NAME("lastName"),
  EMAIL_ADDRESS("emailAddress"),
  ADDRESS("address"),
  COUNTRY("country"),
  STATE("state"),
  PHONE_NUMBER("phoneNumber");

  private final String queryName;

  SortBy(String queryName) {
    this.queryName = queryName;
  }
}
