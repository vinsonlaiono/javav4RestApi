package com.javav4.springdata.restapi.controllers;

import com.javav4.springdata.restapi.models.Song;
import com.javav4.springdata.restapi.repositories.SongRepository;
import com.javav4.springdata.restapi.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    @Autowired
    private SongService songServ;
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public List<Song> getAllSongs(){
        return songServ.findAllSongs();
    }
    @GetMapping("/song/{id}")
    public Song findSong(@PathVariable("id") String id){
        return songServ.findSong(Long.valueOf(id));
    }
    @PostMapping("/createSong")
    public Song createSong(@RequestBody Song song){
        songServ.createSong(song);
        return song;
    }
    @DeleteMapping("/delete/{id}")
    public Song delete(@PathVariable("id") String id){
        Song song = songServ.findSong(Long.valueOf(id));
        songServ.deleteSong(song);
        return song;
    }
    @PutMapping("/edit/{id}")
    public Song edit(@PathVariable("id") String id,
                     @RequestBody Song song){
        Song songToBeUpdated = songServ.findSong(Long.valueOf(id));
        songToBeUpdated.setName(song.getName());
        songToBeUpdated.setArtist(song.getArtist());
        songToBeUpdated.setRating(song.getRating());

        return songServ.updateSong(songToBeUpdated);
    }

}
