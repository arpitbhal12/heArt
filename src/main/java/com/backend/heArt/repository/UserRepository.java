package com.backend.heArt.repository;

import com.backend.heArt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String phone);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByPhone(String phone);
}
