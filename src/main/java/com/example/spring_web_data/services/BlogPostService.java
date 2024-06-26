package com.example.spring_web_data.services;

import com.example.spring_web_data.controllers.BlogPostController;
import com.example.spring_web_data.entities.Autore;
import com.example.spring_web_data.entities.BlogPost;
import com.example.spring_web_data.payLoads.BlogPostPayload;
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


    //cerca i blogpost per ID
    public BlogPost findById(int id){
        return blogPostRepository.findById(id).orElseThrow(()-> new RuntimeException("Post non trovato"));
    }



    //creazione dei BlogPost
    public BlogPost saveBlogPost(BlogPostPayload blogPayload){
        //cerchiamo tramite id che abbiamo passato nel Body del Payload l'autore da associare al BlogPost
        Autore autore = autoreService.findByID(blogPayload.getAutoreId());

        //ci creiamo l'oggetto BlogPost e gli passiamo tra i parametri tutte le cose che dobbiamo settare
        //le cose da settare le prendiamo tramite il get sul payload

        BlogPost blogPost = new BlogPost(blogPayload.getCategoria(),blogPayload.getTitolo(),null,blogPayload.getContenuto(),blogPayload.getTempoDiLettura(), autore);

        //una volta che abbiamo creato l'oggetto blogpost lo salviamo con la funzione save della repository

        return blogPostRepository.save(blogPost);


    }
}
