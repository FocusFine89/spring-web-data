package com.example.spring_web_data.autore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
    Autore findByEmail(String email);

    boolean existsByEmail(String email);



}
