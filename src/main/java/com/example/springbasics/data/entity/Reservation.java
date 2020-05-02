package com.example.springbasics.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="RESERVATION")
@Data
public class Reservation {
    @Id
    @Column(name="RESERVATION_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long reservation_Id;

    @Column(name="ROOM_ID")
    private Long room_Id;

    @Column(name="GUEST_ID")
    private Long guest_Id;

    @Column(name="RES_DATE")
    private Date res_Date;
}
