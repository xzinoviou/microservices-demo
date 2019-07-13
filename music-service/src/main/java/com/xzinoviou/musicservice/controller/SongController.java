package com.xzinoviou.musicservice.controller;

import com.xzinoviou.musicservice.model.Song;
import com.xzinoviou.musicservice.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author xzinoviou
 * created 13/7/2019
 */
@RestController
@RequestMapping("api/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable("id") Long id) {
        return ResponseEntity.ok(songService.getSong(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.create(song), CREATED);
    }

    @PutMapping
    public ResponseEntity<Song> updateBook(@RequestBody Song song) {
        return ResponseEntity.ok(songService.update(song));
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songService.delete(id);
    }
}
