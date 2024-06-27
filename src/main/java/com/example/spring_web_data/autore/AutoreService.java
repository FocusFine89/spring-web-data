package com.example.spring_web_data.autore;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;

    @Autowired
    Cloudinary cloudinaryUploader;


    //creazione Autore
    public Autore saveAutore(AutorePayload newautore){
        if( this.autoreRepository.findByEmail(newautore.email())!=null){
            throw new RuntimeException("L'email " + newautore.email() + " è gia stata registrata!"); //TODO creare un file di gestione Errori
        }
        Autore autore = new Autore(newautore.nome(), newautore.cognome(), newautore.email(), newautore.dataDiNascita());
        autore.setAvatar("http://ui-avatar.com/" + newautore.nome() + "+" + newautore.cognome());
        return this.autoreRepository.save(autore);

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


    public String uploadProfileImg(MultipartFile imgFile) throws IOException {
        return (String) cloudinaryUploader.uploader().upload(imgFile.getBytes(), ObjectUtils.emptyMap()).get("url");
    }


}
