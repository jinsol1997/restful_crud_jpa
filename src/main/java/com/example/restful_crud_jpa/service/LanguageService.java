package com.example.restful_crud_jpa.service;

import com.example.restful_crud_jpa.domain.LanguageDTO;
import com.example.restful_crud_jpa.entity.LanguageEntity;
import com.example.restful_crud_jpa.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Optional<LanguageEntity> selectById(Integer id){
        return languageRepository.findById(id);
    }

    public List<LanguageEntity> selectAll(){
        return languageRepository.findAll();
    }

    public LanguageEntity insert(LanguageDTO languageDTO){
        return languageRepository.save(languageDTO.toEntity());
    }

    public LanguageEntity update(LanguageDTO languageDTO){
        return languageRepository.save(languageDTO.toEntity());
    }

    public void deleteById(Integer id){
        languageRepository.deleteById(id);
    }

}
