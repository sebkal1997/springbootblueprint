package com.example.blueprint.repository;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Data
@Builder
public class Foo {

    @Id
    private String id;

    @NotBlank
    private String name;

}
