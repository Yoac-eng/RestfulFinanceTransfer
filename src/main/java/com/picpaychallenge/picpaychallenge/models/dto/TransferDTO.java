package com.picpaychallenge.picpaychallenge.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Transfer DTO class.
 *
 * @author Cayo Cutrim
 * @since 13/11/2023
 */

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class TransferDTO {

    private Long id;
    private BigDecimal amount;
    private Long senderId;
    private Long receiverId;

}
