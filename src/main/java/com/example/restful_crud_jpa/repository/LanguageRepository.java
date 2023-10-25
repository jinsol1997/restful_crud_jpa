package com.example.restful_crud_jpa.repository;

import com.example.restful_crud_jpa.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer> {
}
