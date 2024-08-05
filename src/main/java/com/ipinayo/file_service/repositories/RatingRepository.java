package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.Rating;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RatingRepository extends ReactiveCrudRepository<Rating, Long> {

    Flux<Rating> findBySheetMusicId(Long sheetMusicId);

}
