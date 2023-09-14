package com.picpaychallenge.picpaychallenge.models.repositories;

import com.picpaychallenge.picpaychallenge.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
