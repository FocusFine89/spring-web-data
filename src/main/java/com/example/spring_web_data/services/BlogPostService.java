package com.example.spring_web_data.services;

import com.example.spring_web_data.controllers.BlogPostController;
import com.example.spring_web_data.entities.BlogPost;
import com.example.spring_web_data.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository blogPostRepository;

    @Autowired AutoreService autoreService;

    //cerca tutti i blogpost impaginati
    public Page<BlogPost> getBlogPost(int pageNumber, int pageSize){
        if(pageSize>20) pageSize=20;
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        return blogPostRepository.findAll(pageable);

    }

    //crea blogpost
    public BlogPost saveBlogPost(BlogPost newBlogPost){
        this.blogPostRepository.findByTitolo(newBlogPost.getTitolo()).ifPresent(
                blogPost -> {
                    throw new RuntimeException("Esiste già un blog con quest titolo: " + newBlogPost.getTitolo());
                }
        );
        return blogPostRepository.save(newBlogPost);
    }
}
