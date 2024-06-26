package com.example.spring_web_data.repositories;

import com.example.spring_web_data.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    Optional<BlogPost> findByTitolo(String titolo);

    boolean existsByTitolo(String titolo);
}
