package com.ipinayo.file_service.entities;

import com.ipinayo.file_service.enums.SheetMusicLifecycleLogEvent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lifecycle_log")
public class LifecycleLog {

    @Id
    private Long id;

    @Column("sheet_music_id")
    private String sheetMusicId;

    private SheetMusicLifecycleLogEvent event;

    @Column("user_id")
    private String userId;

    @Column("log_time")
    private Instant log_time;

    private String details;

}
