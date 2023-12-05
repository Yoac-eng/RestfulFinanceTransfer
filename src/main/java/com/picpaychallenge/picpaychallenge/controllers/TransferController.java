package com.picpaychallenge.picpaychallenge.controllers;


import com.picpaychallenge.picpaychallenge.models.dto.TransferDTO;
import com.picpaychallenge.picpaychallenge.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Return all the users registered.
     *
     * @return List<UserDTO> A list containing all the registered UsersDTOs.
     */
    @GetMapping
    public List<TransferDTO> findAll(){
        List<TransferDTO> result = transferService.findAll();
        return result;
    }

    /**
     * Make a new transfer.
     * @param newTransfer The transferDTO object containing the details of the transfer to be created.
     * @return ResponseEntity<TransferDTO> The ResponseEntity containing the newly created TransferDTO.
     */
    @PostMapping
    public ResponseEntity<TransferDTO> newTransfer(@RequestBody TransferDTO newTransfer){
        TransferDTO result = transferService.save(newTransfer);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
