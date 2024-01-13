package com.javav4.springdata.restapi.services;

import com.javav4.springdata.restapi.models.Song;
import com.javav4.springdata.restapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepo;

    public List<Song> findAllSongs(){
        return (List<Song>) songRepo.findAll();
    }
    public Song findSong(Long id){
        Optional<Song> song = songRepo.findById(id);
        if(song.isPresent()){
            return song.get();
        } else {
            return null;
        }
    }
    public Song createSong(Song song) {
        return songRepo.save(song);
    }

    public void deleteSong(Song song) {
        songRepo.delete(song);
    }

    public Song updateSong(Song song) {
        return songRepo.save(song);
    }
}
