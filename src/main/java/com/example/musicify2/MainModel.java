package com.example.musicify2;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "music")
public class MainModel {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songname;
    
    @Lob
    private byte[] songData;

    private String genre;

    private String artist;
        
    @Lob
    private byte[] songimage;


    public MainModel() {
    }

    public MainModel(Long id, String songname, byte[] songData, String genre, String artist, byte[] songimage) {
        this.id = id;
        this.songname = songname;
        this.songData = songData;
        this.genre = genre;
        this.artist = artist;
        this.songimage = songimage;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongname() {
        return this.songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public byte[] getSongData() {
        return this.songData;
    }

    public void setSongData(byte[] songData) {
        this.songData = songData;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public byte[] getSongimage() {
        return this.songimage;
    }

    public void setSongimage(byte[] songimage) {
        this.songimage = songimage;
    }

    public MainModel id(Long id) {
        setId(id);
        return this;
    }

    public MainModel songname(String songname) {
        setSongname(songname);
        return this;
    }

    public MainModel songData(byte[] songData) {
        setSongData(songData);
        return this;
    }

    public MainModel genre(String genre) {
        setGenre(genre);
        return this;
    }

    public MainModel artist(String artist) {
        setArtist(artist);
        return this;
    }

    public MainModel songimage(byte[] songimage) {
        setSongimage(songimage);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MainModel)) {
            return false;
        }
        MainModel mainModel = (MainModel) o;
        return Objects.equals(id, mainModel.id) && Objects.equals(songname, mainModel.songname) && Objects.equals(songData, mainModel.songData) && Objects.equals(genre, mainModel.genre) && Objects.equals(artist, mainModel.artist) && Objects.equals(songimage, mainModel.songimage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songname, songData, genre, artist, songimage);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", songname='" + getSongname() + "'" +
            ", songData='" + getSongData() + "'" +
            ", genre='" + getGenre() + "'" +
            ", artist='" + getArtist() + "'" +
            ", songimage='" + getSongimage() + "'" +
            "}";
    }
   
}
