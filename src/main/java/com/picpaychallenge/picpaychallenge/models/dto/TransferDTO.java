package com.picpaychallenge.picpaychallenge.models.dto;

import com.picpaychallenge.picpaychallenge.models.Transfer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private BigDecimal amount;
    private Long senderId;
    private Long receiverId;

}
