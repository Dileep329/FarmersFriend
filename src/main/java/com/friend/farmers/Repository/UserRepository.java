package com.friend.farmers.Repository;

import com.friend.farmers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

    Optional<User> findByUserName(String username);
}
