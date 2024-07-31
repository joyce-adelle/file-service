package com.ipinayo.file_service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    private Long id;

    @Column("sheet_music_id")
    private String sheetMusicId;

    @Column("user_id")
    private String userId;

    private Integer rate;

}
