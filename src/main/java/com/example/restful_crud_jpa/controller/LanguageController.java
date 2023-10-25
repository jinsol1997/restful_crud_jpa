package com.example.restful_crud_jpa.controller;

import com.example.restful_crud_jpa.domain.LanguageDTO;
import com.example.restful_crud_jpa.entity.LanguageEntity;
import com.example.restful_crud_jpa.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("find/{id}")
    public ResponseEntity<LanguageEntity> getLanguageById(@PathVariable Integer id){

        LanguageEntity languageEntity = languageService.selectById(id).orElse(null);

        if(languageEntity != null){
            return new ResponseEntity<>(languageEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(languageEntity, HttpStatus.NOT_FOUND);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<LanguageEntity>> getAllLanguage(){

        List<LanguageEntity> languageEntities = languageService.selectAll();

        if(languageEntities != null){
            return new ResponseEntity<>(languageEntities, HttpStatus.OK);
        }

        return new ResponseEntity<>(languageEntities, HttpStatus.NOT_FOUND);

    }

    @PostMapping("create")
    public ResponseEntity<LanguageEntity> createLanguage(@RequestBody LanguageDTO languageDTO){

        LanguageEntity createLanguageEntity = languageService.insert(languageDTO);

        if(createLanguageEntity != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<LanguageEntity> updateLanguage(@PathVariable Integer id, @RequestBody LanguageDTO languageDTO){

        if(languageService.selectById(id).isPresent()){

            languageDTO.setLanguage_id(id);
            languageService.update(languageDTO);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<LanguageEntity> deleteLanguage(@PathVariable Integer id){

        if(languageService.selectById(id).isPresent()){
            languageService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
