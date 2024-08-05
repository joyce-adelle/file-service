package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.SheetMusic;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SheetMusicRepository extends ReactiveCrudRepository<SheetMusic, String> {

}
