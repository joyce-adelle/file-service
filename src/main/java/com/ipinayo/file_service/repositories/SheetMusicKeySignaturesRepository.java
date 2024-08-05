package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.SheetMusicKeySignatures;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SheetMusicKeySignaturesRepository extends ReactiveCrudRepository<SheetMusicKeySignatures, Long> {

    Flux<Void> findBySheetMusicId(Long sheetMusicId);

    Mono<Void> deleteBySheetMusicId(Long sheetMusicId);

}
