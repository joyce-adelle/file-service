package com.ipinayo.file_service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "sheet_music")
public class SheetMusic {

    @Id
    private String id;

    private String title;

    @Column("sub_title")
    private String subTitle;

    private String lyricist;

    private String composer;

    private String arranger;

    private int tempo;

    @Column("time_signature")
    private String timeSignature;

    private String description;

    @Column("file_path")
    private String filePath;

    @Column("page_count")
    private Integer pageCount;

    @Column("cover_image_path")
    private String coverImagePath;

    @Column("average_rating")
    private Double averageRating;

    @Column("rating_count")
    private Long ratingCount;

    @Column("uploaded_by_id")
    private String uploadedById;

    private Boolean approved;

    private Boolean enabled;

    @Column("extracted_text")
    private String extractedText;

}
