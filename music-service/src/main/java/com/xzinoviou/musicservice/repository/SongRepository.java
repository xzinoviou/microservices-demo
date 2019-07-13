package com.xzinoviou.musicservice.repository;

import com.xzinoviou.musicservice.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** @author xzinoviou created 13/7/2019 */
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {}
