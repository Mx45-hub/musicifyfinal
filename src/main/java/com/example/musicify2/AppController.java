package com.example.musicify2;



import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
public class AppController {

    @GetMapping("/upload")
    public String upload(){
        return "upload";
    }

    private final MainService mainService;

    @Autowired
    public AppController(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam String artistname, @RequestParam String genre,  @RequestParam String songname, @RequestParam MultipartFile imageFile, @RequestParam MultipartFile songFile, Model model) {
        try {
            mainService.uploadSong(artistname, genre, songname, imageFile, songFile);
            model.addAttribute("success", "The Image and Song were successfully added");
            return "upload";
        } catch (IOException e) {
            return "error";
        }
    }
};
