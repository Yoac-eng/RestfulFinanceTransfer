package com.picpaychallenge.picpaychallenge.controllers;


import com.picpaychallenge.picpaychallenge.models.dto.TransferDTO;
import com.picpaychallenge.picpaychallenge.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Default controller to handle Transfer related requests.
 *
 * @author Cayo Cutrim
 * @since 13/11/2023
 */
@RestController
@RequestMapping(value = "/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping
    public List<TransferDTO> findAll(){
        List<TransferDTO> result = transferService.findAll();
        return result;
    }
}
