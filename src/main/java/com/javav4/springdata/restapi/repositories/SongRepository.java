package com.javav4.springdata.restapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javav4.springdata.restapi.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> { }