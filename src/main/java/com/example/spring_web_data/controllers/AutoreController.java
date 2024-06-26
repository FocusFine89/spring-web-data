package com.example.spring_web_data.controllers;


import com.example.spring_web_data.entities.Autore;
import com.example.spring_web_data.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    //Lista di tutti gli autori impaginati
    @GetMapping
    public Page<Autore> findAllAutori(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize){
        return autoreService.getAutori(pageNumber, pageSize);
    }

    //Salva autore
    @PostMapping
    public Autore saveAutore(@RequestBody Autore autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/{id}")
    public Autore findAutoreById(@PathVariable int id){
        return autoreService.findByID(id);
    }
}
