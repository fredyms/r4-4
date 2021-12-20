package com.retos.repository.crud;

import com.retos.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @ autor  Martinez
 **/
public interface UserRepository extends MongoRepository<User, Integer> {
    /**
     * Retorna las ordenes de pedido que coincidad con la zona recibida como parametro por
     * identification
     *
     * @param identification
     * @return
     */
    @Query("{'identification': ?0}")
    Optional<User> findByIdentificacion(final String identification);

    /**
     * Método para listar usuarios cuyo mes de cumpleaños sea el ingresado
     *
     * @param month
     * @return
     */
    List<User> findByMonthBirthtDay(String month);



}
