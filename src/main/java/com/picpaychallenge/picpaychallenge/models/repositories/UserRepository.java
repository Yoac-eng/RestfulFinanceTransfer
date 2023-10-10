package com.picpaychallenge.picpaychallenge.models.repositories;

import com.picpaychallenge.picpaychallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByDocument(String document);
}
