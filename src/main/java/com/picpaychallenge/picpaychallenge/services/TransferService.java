package com.picpaychallenge.picpaychallenge.services;

import com.picpaychallenge.picpaychallenge.models.dto.TransferDTO;

import java.util.List;

/**
 * User service interface.
 *
 * @author Cayo Cutrim
 * @since 13/11/2023
 */
public interface TransferService {

    /**
     * Return all the transfers registered.
     *
     * @return List<TransferDTO> A list containing all the registered TransfersDTOs.
     */
    public List<TransferDTO> findAll();
}
