package com.ipinayo.file_service.entities;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sheet_music_audios")
public class SheetMusicAudios {

    @Column("audio_id")
    private Long audioId;

    @Column("sheet_music_id")
    private String sheetMusicId;

}
