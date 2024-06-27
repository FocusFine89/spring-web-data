package com.example.spring_web_data.blogPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
    Optional<BlogPost> findByTitolo(String titolo);

    boolean existsByTitolo(String titolo);

}
