package com.example.restful_crud_jpa.domain;

import com.example.restful_crud_jpa.entity.LanguageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDTO {

    private Integer language_id;

    private String name;

    private Timestamp last_update;

    public LanguageEntity toEntity(){
        return new LanguageEntity().builder()
                .language_id(language_id)
                .name(name)
                .last_update(new Timestamp(System.currentTimeMillis()))
                .build();
    }

}
