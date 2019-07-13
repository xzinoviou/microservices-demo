package com.xzinoviou.musicservice.service;

import com.xzinoviou.musicservice.exception.JpaException;
import com.xzinoviou.musicservice.model.Song;
import com.xzinoviou.musicservice.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/** @author xzinoviou created 13/7/2019 */
@Service
public class SongServiceImpl implements SongService {

  private final SongRepository songRepository;

  public SongServiceImpl(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @Override
  public Song getSong(Long id) {
    return songRepository
        .findById(id)
        .orElseThrow(() -> new JpaException("Entity with id : " + id + " was not Found"));
  }

  @Override
  public List<Song> getAllSongs() {
    return songRepository.findAll();
  }

  @Override
  public Song create(Song song) {
    return songRepository.save(song);
  }

  @Override
  public void delete(Long id) {
    songRepository.deleteById(id);
  }

  @Override
  public Song update(Song song) {
    return songRepository.save(song);
  }
}
