package com.picpaychallenge.picpaychallenge.services.utils;

import com.picpaychallenge.picpaychallenge.exception.InvalidFieldException;
import com.picpaychallenge.picpaychallenge.models.Transfer;
import com.picpaychallenge.picpaychallenge.models.User;
import com.picpaychallenge.picpaychallenge.models.enums.UserType;
import com.picpaychallenge.picpaychallenge.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Utility class for handling transfer logic
 *
 * @author Cayo Cutrim
 * @since 04/12/2023
 */
@Component
public class TransferUtils {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param transfer
     * Validate if a transfer is valid to be done.
     */
    public void isTransferViable(Transfer transfer){
        if (transfer.getSender().getUserType() == UserType.MERCHANT){
            throw new InvalidFieldException("Lojistas não podem realizar transferências, apenas receber.");
        }
        if (transfer.getSender().getBalance().compareTo(transfer.getAmount()) < 0){
            throw new InvalidFieldException("A tentativa de transferência excede o valor presente na conta do usuário.");
        }
    }

    /**
     * @param transfer
     * Does the actual transfer logic.
     */
    public void performTransfer(Transfer transfer) {
        adjustAccountBalance(transfer.getSender(), transfer.getAmount().negate());
        adjustAccountBalance(transfer.getReceiver(), transfer.getAmount());
    }

    /**
     * @param user
     * @param amount
     * Adjusts the user balance according to the transfer amount and save it.
     */
    private void adjustAccountBalance(User user, BigDecimal amount) {
        user.setBalance(user.getBalance().add(amount));
        userRepository.save(user);
    }
}
