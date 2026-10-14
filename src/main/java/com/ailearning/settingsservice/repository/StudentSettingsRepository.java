package com.ailearning.settingsservice.repository;

import com.ailearning.settingsservice.entity.StudentSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentSettingsRepository extends JpaRepository<StudentSettings, Long> {

    Optional<StudentSettings> findByUserId(Long userId);

    boolean existsByUserId(Long userId);
}
