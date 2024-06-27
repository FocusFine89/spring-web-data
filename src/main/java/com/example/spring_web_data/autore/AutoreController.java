package com.example.spring_web_data.autore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public Autore saveAutore(@RequestBody @Validated AutorePayload autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/{id}")
    public Autore findAutoreById(@PathVariable int id){
        return autoreService.findByID(id);
    }

    //Upload Avatar dell'account
    @PostMapping("/{id}/avatar")
    public String uploadAvatar(@RequestParam("avatar")MultipartFile image) throws IOException{
        // il request param "avatar" deve corrispondere ESATTAMENTE alla chiave del payload Multipart dove stiamo
        // allegando il file. Se non corrispondono il file non verrà trovato

        return this.autoreService.uploadProfileImg(image);
    }
}
