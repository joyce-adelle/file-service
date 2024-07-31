package com.ipinayo.file_service.entities;

import com.ipinayo.file_service.enums.KeySignature;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sheet_music_key_signatures")
public class SheetMusicKeySignatures {

    @Column("key_signature")
    private KeySignature keySignature;

    @Column("sheet_music_id")
    private String sheetMusicId;

}
