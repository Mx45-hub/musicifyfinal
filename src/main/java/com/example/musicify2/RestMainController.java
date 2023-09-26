package com.example.musicify2;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class RestMainController {

    MainService service;
    MainRepository repository;
    MainModel model;


    public RestMainController(MainService service, MainRepository repository, MainModel model) {
        this.service = service;
        this.repository = repository;
        this.model = model;
    }

    @Autowired
    public RestMainController(MainService service) {
        this.service = service;
    }


    @GetMapping("/songs")
    @ResponseBody
    public List<MainModel> allsongs() {
    List<MainModel> imageEntities = service.findAll();
    System.out.println(imageEntities);
    return imageEntities;
    }


    //http://localhost:8080/artist?artist=Drake
    @GetMapping("/artist")
    @ResponseBody
    public List<MainModel> artist(@RequestParam String artist) {
    List<MainModel> imageEntities = service.findByArtist(artist);
    return imageEntities;
}
    //http://localhost:8080/genre?genre=Rap
    @GetMapping("/genre")
    @ResponseBody
    public List<MainModel> genre(@RequestParam String genre) {
    List<MainModel> imageEntities = service.findByGenre(genre);
    System.out.println(imageEntities);
    return imageEntities;
}

    @PostMapping("/uploaddata")
    public ResponseEntity<String> uploadImage(@RequestParam String artistname, @RequestParam String genre,  @RequestParam String songname, @RequestParam MultipartFile imageFile, @RequestParam MultipartFile songFile) {
        try {
            service.uploadSong(artistname, genre, songname, imageFile, songFile);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SUCCESFULLY UPLOADED");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }

    }
}