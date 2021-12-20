package com.retos.repository.crud;

import com.retos.model.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @ autor  Martinez
 **/
public interface ClotheRepository extends MongoRepository<Clothe, Integer> {
    /**
     * Listar Clothes que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    List<Clothe> findClotheByPriceIsLessThanEqual(Double price);

    /**
     * Listar Clothes por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    List<Clothe> findClotheByDescriptionRegex(String description);

}
