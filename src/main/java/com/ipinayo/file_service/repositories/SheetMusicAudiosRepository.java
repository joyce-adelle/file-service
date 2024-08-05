package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.SheetMusicAudios;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SheetMusicAudiosRepository extends ReactiveCrudRepository<SheetMusicAudios, Long> {

    Flux<SheetMusicAudios> findBySheetMusicId(Long sheetMusicId);

    Flux<SheetMusicAudios> findByAudioId(Long audioId);

    Mono<Void> deleteBySheetMusicIdAndAudioId(Long sheetMusicId, Long audioId);
    
}
