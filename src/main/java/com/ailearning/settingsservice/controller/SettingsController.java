package com.ailearning.settingsservice.controller;

import com.ailearning.settingsservice.dto.request.UpdateSettingsRequest;
import com.ailearning.settingsservice.dto.response.StudentSettingsResponse;
import com.ailearning.settingsservice.service.SettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
@Tag(name = "Student Settings", description = "Endpoints for managing student UI theme, avatars, and sound preferences")
public class SettingsController {

    private final SettingsService settingsService;

    @Operation(summary = "Get student settings by user ID", description = "Retrieves student theme, avatar, and notification preferences. Automatically generates default settings if student is new.")
    @GetMapping("/user/{userId}")
    public ResponseEntity<StudentSettingsResponse> getSettings(@PathVariable Long userId) {
        StudentSettingsResponse response = settingsService.getSettingsByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update student settings", description = "Updates student theme, avatar, and sound preferences")
    @PutMapping("/user/{userId}")
    public ResponseEntity<StudentSettingsResponse> updateSettings(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateSettingsRequest request) {

        StudentSettingsResponse response = settingsService.updateSettings(userId, request);
        return ResponseEntity.ok(response);
    }
}
