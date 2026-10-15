package com.ailearning.settingsservice.service;

import com.ailearning.settingsservice.dto.request.UpdateSettingsRequest;
import com.ailearning.settingsservice.dto.response.StudentSettingsResponse;

public interface SettingsService {

    StudentSettingsResponse getSettingsByUserId(Long userId);

    StudentSettingsResponse updateSettings(Long userId, UpdateSettingsRequest request);
}
