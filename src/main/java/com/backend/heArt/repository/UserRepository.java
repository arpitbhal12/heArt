package com.backend.heArt.repository;

import com.backend.heArt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String phone);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByPhone(String phone);

    Boolean existsByConfirmationToken(String confirmationToken);

    @Modifying
    @Query("update User u set u.enabled = ?1 where u.confirmationToken = ?2")
    void setUserEnabled(Boolean enabled, String confirmationToken);

}
