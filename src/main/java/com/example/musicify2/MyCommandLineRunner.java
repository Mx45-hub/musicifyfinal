package com.example.musicify2;


import java.io.IOException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

@Component
@Order(1) // Specify the order of execution (optional)
public class MyCommandLineRunner implements CommandLineRunner {

    private MainService service;
    private MainRepository repository;
    private ResourceLoader resourceLoader;
    

    public MyCommandLineRunner(MainRepository repository, ResourceLoader resourceLoader) {
        this.repository = repository;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(String... args) throws Exception {
        // Your initialization logic here
        System.out.println("Initialization logic executed by MyCommandLineRunner");

        try {
            // Define the resource paths
            String songDataPath1 = "classpath:DbData/The Last Heartbreak - Copy.mp3";
            String songImagePath1 = "classpath:DbData/last.jpg";


            // Load the song data from the resources
            Resource songDataResource1 = resourceLoader.getResource(songDataPath1);
            Resource songImageResource1 = resourceLoader.getResource(songImagePath1);


            // Check if both resources exist
            if (songDataResource1.exists() && songImageResource1.exists()) {
                // Read the contents of the files into byte arrays
                byte[] songData1 = StreamUtils.copyToByteArray(songDataResource1.getInputStream());
                byte[] songImage1 = StreamUtils.copyToByteArray(songImageResource1.getInputStream());

                
                // Create a MainModel instance and set the song data
                MainModel savesong1 = new MainModel();
                savesong1.setArtist("drake");
                savesong1.setGenre("RNB");
                savesong1.setSongname("heartbreak");
                savesong1.setSongData(songData1);
                savesong1.setSongimage(songImage1);
                repository.save(savesong1);

              

                System.out.println("Song uploaded successfully.");
            } else {
                System.err.println("Song file(s) not found.");
            }
        } catch (IOException e) {
            System.err.println("Error uploading the song: " + e.getMessage());
        }
    }        
}