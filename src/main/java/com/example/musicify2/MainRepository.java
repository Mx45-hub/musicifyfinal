package com.example.musicify2;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<MainModel, Long> {

    List<MainModel> findBygenre(String genre);

    List<MainModel> findByartist(String artist);
}

