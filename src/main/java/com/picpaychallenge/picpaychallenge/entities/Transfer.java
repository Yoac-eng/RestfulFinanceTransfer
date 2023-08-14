package com.picpaychallenge.picpaychallenge.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transfers")
@Data
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private Long sender;
    private Long receiver;
}
