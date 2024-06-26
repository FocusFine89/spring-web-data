package com.example.spring_web_data.services;

import com.example.spring_web_data.entities.Autore;
import com.example.spring_web_data.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;


    //creazione Autore
    public Autore saveAutore(Autore newautore){
        if( this.autoreRepository.findByEmail(newautore.getEmail())!=null){
            throw new RuntimeException("L'email " + newautore.getEmail() + " è gia stata registrata!"); //TODO creare un file di gestione Errori
        }

        newautore.setAvatar("https://ui-avatars.com/api/?name=" + newautore.getNome() + "+" + newautore.getCognome());
        return autoreRepository.save(newautore);
    }


    //Lista di tutti gli autori impaginati
   public Page<Autore> getAutori(int pageNumber, int pageSize){
        if(pageSize>20) pageSize=20;
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return autoreRepository.findAll(pageable);

    }

    public Autore findByID(int id){
       return autoreRepository.findById(id).orElseThrow( ()-> new RuntimeException("utente non trovato"));
    }



}
