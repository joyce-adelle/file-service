package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.Audio;
import com.ipinayo.file_service.entities.Category;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

    Flux<Category> findByParentIsNull();

    Flux<Category> findByNameContainingIgnoreCase(String name);

    @Query("SELECT c.* FROM category c " +
           "INNER JOIN sheet_music_categories smc ON c.id = smc.category_id " +
           "WHERE smc.sheet_music_id = :sheetMusicId")
    Flux<Category> findCategoriesBySheetMusicId(Long sheetMusicId);

}
