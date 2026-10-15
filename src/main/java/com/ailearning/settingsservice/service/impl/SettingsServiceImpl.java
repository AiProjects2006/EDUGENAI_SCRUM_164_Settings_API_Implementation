package com.ailearning.settingsservice.service.impl;

import com.ailearning.settingsservice.dto.request.UpdateSettingsRequest;
import com.ailearning.settingsservice.dto.response.StudentSettingsResponse;
import com.ailearning.settingsservice.entity.StudentSettings;
import com.ailearning.settingsservice.repository.StudentSettingsRepository;
import com.ailearning.settingsservice.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService {

    private final StudentSettingsRepository settingsRepository;

    @Override
    @Transactional
    public StudentSettingsResponse getSettingsByUserId(Long userId) {
        // Find existing settings, or create default settings if the student is new
        StudentSettings settings = settingsRepository.findByUserId(userId)
                .orElseGet(() -> createDefaultSettings(userId));

        return mapToResponse(settings);
    }

    @Override
    @Transactional
    public StudentSettingsResponse updateSettings(Long userId, UpdateSettingsRequest request) {
        StudentSettings settings = settingsRepository.findByUserId(userId)
                .orElseGet(() -> createDefaultSettings(userId));

        // Update fields if provided in request
        if (request.getTheme() != null) {
            settings.setTheme(request.getTheme());
        }
        if (request.getAvatar() != null) {
            settings.setAvatar(request.getAvatar());
        }
        if (request.getVoiceGuidanceEnabled() != null) {
            settings.setVoiceGuidanceEnabled(request.getVoiceGuidanceEnabled());
        }
        if (request.getAmbientMusicEnabled() != null) {
            settings.setAmbientMusicEnabled(request.getAmbientMusicEnabled());
        }
        if (request.getMissionRemindersEnabled() != null) {
            settings.setMissionRemindersEnabled(request.getMissionRemindersEnabled());
        }

        StudentSettings saved = settingsRepository.save(settings);
        return mapToResponse(saved);
    }

    private StudentSettings createDefaultSettings(Long userId) {
        StudentSettings defaults = StudentSettings.builder()
                .userId(userId)
                .theme("daytime")
                .avatar("twemoji:boy")
                .voiceGuidanceEnabled(true)
                .ambientMusicEnabled(true)
                .missionRemindersEnabled(true)
                .build();

        return settingsRepository.save(defaults);
    }

    private StudentSettingsResponse mapToResponse(StudentSettings entity) {
        return StudentSettingsResponse.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .theme(entity.getTheme())
                .avatar(entity.getAvatar())
                .voiceGuidanceEnabled(entity.getVoiceGuidanceEnabled())
                .ambientMusicEnabled(entity.getAmbientMusicEnabled())
                .missionRemindersEnabled(entity.getMissionRemindersEnabled())
                .build();
    }
}
