package com.ailearning.settingsservice.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSettingsRequest {

    @Pattern(regexp = "^(daytime|midnight)$", message = "Theme must be either 'daytime' or 'midnight'")
    private String theme;

    private String avatar;

    private Boolean voiceGuidanceEnabled;

    private Boolean ambientMusicEnabled;

    private Boolean missionRemindersEnabled;
}
