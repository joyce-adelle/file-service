package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.LifecycleLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LifecycleRepository extends ReactiveCrudRepository<LifecycleLog, Long> {

    Flux<LifecycleLog> findBySheetMusicId(Long sheetMusicId);

}
