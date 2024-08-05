package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.SheetMusicCategories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SheetMusicCategoriesRepository extends ReactiveCrudRepository<SheetMusicCategories, Long> {

    Flux<SheetMusicCategories> findBySheetMusicId(Long sheetMusicId);

    Mono<Void> deleteBySheetMusicIdAndCategoryId(Long sheetMusicId, Long categoryId);

}
