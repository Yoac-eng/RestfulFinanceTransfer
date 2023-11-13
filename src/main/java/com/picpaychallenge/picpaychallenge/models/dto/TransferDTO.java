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

    private Long id;
    private BigDecimal amount;
    private UserDTO sender;
    private UserDTO receiver;
    private LocalDateTime timestamp;

    public TransferDTO(Transfer entity){
        id = entity.getId();
        amount = entity.getAmount();
        sender = new UserDTO(entity.getSender());
        receiver = new UserDTO(entity.getReceiver());
        timestamp = entity.getTimestamp();
    }
}
