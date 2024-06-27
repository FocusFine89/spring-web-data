package com.example.spring_web_data.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    //cerca tutti i BlogPost
    @GetMapping
    public Page<BlogPost> findAllBlogPosts(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize){
        return blogPostService.getBlogPost(pageNumber, pageSize);
    }


    //cerca un BlogPost per ID
    @GetMapping("/{id}")
    public BlogPost findBlogPostById(@PathVariable int id){
        return blogPostService.findById(id);
    }

    //creazione BlogPost
    //alla creazione del BlogPost come Body gli passiamo quello del payload che è più veritiero, perchè non vengono settate
    // le cose che poi verranno generate automaticamente dal server in questo caso id e cover
    @PostMapping
    public BlogPost saveBlogPost(@RequestBody BlogPostPayload blogPayload){
        return blogPostService.saveBlogPost(blogPayload);
    }




}
