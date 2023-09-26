package com.example.musicify2;



import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MainService {

    private final MainRepository repository;

    public MainService(MainRepository repository) {
        this.repository = repository;
    }

    public List<MainModel> findAll() {
        return repository.findAll();
    }

    public List<MainModel> findByGenre(String genre) {
        return repository.findBygenre(genre);
    }

    public List<MainModel> findByArtist(String artist) {
        return repository.findByartist(artist);
    }

    public void uploadSong(String artistname, String genre, String songname, MultipartFile imageFile, MultipartFile songFile) throws IOException {
        MainModel imageEntity = new MainModel();
        imageEntity.setArtist(artistname);
        imageEntity.setGenre(genre);
        imageEntity.setSongname(songname);
        imageEntity.setSongData(songFile.getBytes());
        imageEntity.setSongimage(imageFile.getBytes());
        repository.save(imageEntity);
    }
}
