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
@Table( name = "audio")
public class Audio {

    @Id
    private Long id;

    private String name;

    private String description;

    @Column("file_path")
    private String filePath;

    @Column("file_format")
    private String fileFormat;

    @Column("file_size_bytes")
    private Long fileSizeBytes;

    private String duration;

    private Integer bpm;

}
