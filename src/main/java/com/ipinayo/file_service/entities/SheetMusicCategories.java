package com.ipinayo.file_service.entities;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sheet_music_categories")
public class SheetMusicCategories {

    @Column("category_id")
    private Long categoryId;

    @Column("sheet_music_id")
    private String sheetMusicId;

}
