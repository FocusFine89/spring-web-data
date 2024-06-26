package com.example.spring_web_data.repositories;

import com.example.spring_web_data.entities.Autore;
import com.example.spring_web_data.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
    Optional<BlogPost> findByTitolo(String titolo);

    boolean existsByTitolo(String titolo);

}
