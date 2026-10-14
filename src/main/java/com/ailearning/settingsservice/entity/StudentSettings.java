package com.ailearning.settingsservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "theme", nullable = false)
    @Builder.Default
    private String theme = "daytime";

    @Column(name = "avatar", nullable = false)
    @Builder.Default
    private String avatar = "twemoji:boy";

    @Column(name = "voice_guidance_enabled", nullable = false)
    @Builder.Default
    private Boolean voiceGuidanceEnabled = true;

    @Column(name = "ambient_music_enabled", nullable = false)
    @Builder.Default
    private Boolean ambientMusicEnabled = true;

    @Column(name = "mission_reminders_enabled", nullable = false)
    @Builder.Default
    private Boolean missionRemindersEnabled = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
