package com.picpaychallenge.picpaychallenge.repositories;

import com.picpaychallenge.picpaychallenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
