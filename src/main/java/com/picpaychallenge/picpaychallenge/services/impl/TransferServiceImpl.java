package com.picpaychallenge.picpaychallenge.services.impl;

import com.picpaychallenge.picpaychallenge.models.dto.TransferDTO;
import com.picpaychallenge.picpaychallenge.models.repositories.TransferRepository;
import com.picpaychallenge.picpaychallenge.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TransferDTO> findAll() {
        List<TransferDTO> result = transferRepository.findAll().stream().map(t -> new TransferDTO(t)).toList();
        return result;
    }
}
