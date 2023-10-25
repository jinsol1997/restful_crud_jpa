package com.example.restful_crud_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "language")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageEntity {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer language_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_update", columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp last_update;

}
