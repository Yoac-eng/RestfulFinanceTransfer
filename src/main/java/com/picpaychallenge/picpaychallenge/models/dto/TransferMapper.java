package com.picpaychallenge.picpaychallenge.models.dto;

import com.picpaychallenge.picpaychallenge.exception.ResourceNotFoundException;
import com.picpaychallenge.picpaychallenge.models.Transfer;
import com.picpaychallenge.picpaychallenge.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * TransferMapper Class, used to map an entity into a dto and vice versa.
 *
 * @author Cayo Cutrim
 * @since 16/11/2023
 */
@Component
public class TransferMapper {

    @Autowired
    private UserRepository userRepository;

    public Transfer toEntity(TransferDTO transferDTO) {
        Transfer transfer = new Transfer();
        transfer.setAmount(transferDTO.getAmount());
        transfer.setSender(userRepository.findById(transferDTO.getSenderId())
                .orElseThrow(() -> new ResourceNotFoundException("Sender not found by the given id")));
        transfer.setReceiver(userRepository.findById(transferDTO.getReceiverId())
                .orElseThrow(() -> new ResourceNotFoundException("Receiver not found by the given id")));
        transfer.setTimestamp(LocalDateTime.now());
        return transfer;
    }

    public TransferDTO toDTO(Transfer transfer) {
        TransferDTO dto = new TransferDTO();
        dto.setId(transfer.getId());
        dto.setAmount(transfer.getAmount());
        dto.setSenderId(transfer.getSender().getId());
        dto.setReceiverId(transfer.getReceiver().getId());
        return dto;
    }
}
