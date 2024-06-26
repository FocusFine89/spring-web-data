package com.example.spring_web_data.repositories;

import com.example.spring_web_data.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
    Autore findByEmail(String email);

    boolean existsByEmail(String email);



}
