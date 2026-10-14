package com.ailearning.settingsservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSettingsResponse {

    private Long id;
    private Long userId;
    private String theme;
    private String avatar;
    private Boolean voiceGuidanceEnabled;
    private Boolean ambientMusicEnabled;
    private Boolean missionRemindersEnabled;
}
