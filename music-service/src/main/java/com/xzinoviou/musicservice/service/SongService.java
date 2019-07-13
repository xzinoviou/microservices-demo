package com.xzinoviou.musicservice.service;

import com.xzinoviou.musicservice.model.Song;

import java.util.List;

/** @author xzinoviou created 13/7/2019 */
public interface SongService {

  Song getSong(Long id);

  List<Song> getAllSongs();

  Song create(Song song);

  void delete(Long id);

  Song update(Song song);
}
