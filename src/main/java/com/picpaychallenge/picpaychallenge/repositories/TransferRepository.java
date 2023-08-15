package com.picpaychallenge.picpaychallenge.repositories;

import com.picpaychallenge.picpaychallenge.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository  extends JpaRepository<Transfer, Long> {
}
