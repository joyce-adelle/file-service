package com.ipinayo.file_service.repositories;

import com.ipinayo.file_service.entities.Audio;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AudioRepository extends ReactiveCrudRepository<Audio, Long> {

    @Query("SELECT a.* FROM audio a " +
           "INNER JOIN sheet_music_audios sma ON a.id = sma.audio_id " +
           "WHERE sma.sheet_music_id = :sheetMusicId")
    Flux<Audio> findAudiosBySheetMusicId(Long sheetMusicId);

}
