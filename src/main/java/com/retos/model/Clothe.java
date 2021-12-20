package com.retos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @ autor Martinez
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clothe")
public class Clothe {
    @Id
    private String reference;
    private String category;
    private String size;
    private String description;
    private Boolean availability = true;
    private Double price;
    private Integer quantity;
    private String photography;

}


