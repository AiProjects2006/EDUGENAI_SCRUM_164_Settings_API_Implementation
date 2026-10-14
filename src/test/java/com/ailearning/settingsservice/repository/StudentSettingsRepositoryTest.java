package com.ailearning.settingsservice.repository;

import com.ailearning.settingsservice.entity.StudentSettings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentSettingsRepositoryTest {

    @Autowired
    private StudentSettingsRepository settingsRepository;

    private StudentSettings createSettings(Long userId) {
        return StudentSettings.builder()
                .userId(userId)
                .theme("daytime")
                .avatar("twemoji:boy")
                .voiceGuidanceEnabled(true)
                .ambientMusicEnabled(true)
                .missionRemindersEnabled(true)
                .build();
    }

    @Test
    @DisplayName("Test Save Student Settings")
    void testSaveSettings() {
        StudentSettings settings = createSettings(100L);
        StudentSettings saved = settingsRepository.save(settings);

        assertNotNull(saved.getId());
        assertEquals(100L, saved.getUserId());
        assertEquals("daytime", saved.getTheme());
        assertTrue(saved.getVoiceGuidanceEnabled());
    }

    @Test
    @DisplayName("Test Find By User ID")
    void testFindByUserId() {
        StudentSettings settings = createSettings(200L);
        settingsRepository.save(settings);

        Optional<StudentSettings> found = settingsRepository.findByUserId(200L);

        assertTrue(found.isPresent());
        assertEquals(200L, found.get().getUserId());
        assertEquals("twemoji:boy", found.get().getAvatar());
    }

    @Test
    @DisplayName("Test Exists By User ID")
    void testExistsByUserId() {
        StudentSettings settings = createSettings(300L);
        settingsRepository.save(settings);

        boolean exists = settingsRepository.existsByUserId(300L);
        boolean notExists = settingsRepository.existsByUserId(999L);

        assertTrue(exists);
        assertFalse(notExists);
    }
}
