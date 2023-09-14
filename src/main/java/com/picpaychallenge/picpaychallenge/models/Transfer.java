package com.picpaychallenge.picpaychallenge.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Class that maps the transfers table.
 *
 * @author Cayo Cutrim
 * @since 17/08/2023
 */
@Entity
@Table(name = "transfers")
@Data
@EqualsAndHashCode(of = "id")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

    private LocalDateTime timestamp;
}
