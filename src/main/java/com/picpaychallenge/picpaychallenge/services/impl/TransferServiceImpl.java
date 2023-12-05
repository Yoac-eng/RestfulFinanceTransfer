package com.picpaychallenge.picpaychallenge.services.impl;

import com.picpaychallenge.picpaychallenge.models.Transfer;
import com.picpaychallenge.picpaychallenge.models.dto.TransferDTO;
import com.picpaychallenge.picpaychallenge.models.dto.TransferMapper;
import com.picpaychallenge.picpaychallenge.models.repositories.TransferRepository;
import com.picpaychallenge.picpaychallenge.services.TransferService;
import com.picpaychallenge.picpaychallenge.services.utils.TransferUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransferUtils transferUtils;

    @Autowired
    private TransferMapper transferMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TransferDTO> findAll() {
        return transferRepository.findAll().stream().map(t -> transferMapper.toDTO(t)).toList();
    }

    @Override
    @Transactional
    public TransferDTO save(TransferDTO newTransfer){
        Transfer transfer = transferMapper.toEntity(newTransfer);
        transferUtils.isTransferViable(transfer);

        transferUtils.performTransfer(transfer);

        return transferMapper.toDTO(transferRepository.save(transfer));
    }

}
