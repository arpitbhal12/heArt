package com.backend.heArt.repository;

import com.backend.heArt.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AboutRepository extends JpaRepository<About, Long> {
    Optional<About> findById(Long id);

    About getAboutById(Long id);
}
