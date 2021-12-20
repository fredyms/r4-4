package com.retos.controller;

import com.retos.model.Clothe;
import com.retos.services.ClotheServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @ autor Martinez
 **/
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clothe/")
@AllArgsConstructor

public class ClotheController {

    /**
     * atributo API
     */

    private ClotheServices clotheServices;

    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de
     * usuario por el valor de su atributo 'id', hacia el metodo 'getUserById'
     * del UserService
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Clothe> getUser(@PathVariable("id") String id) {
        return clotheServices.getClotheByReference(id);
    }

    /**
     * Metodo para obtener todos los usarios
     *
     * @return
     */
    @GetMapping("all")
    public List<Clothe> getAll() {
        return clotheServices.getAll();
    }

    /**
     * Metodo para crear un usuario
     *
     * @param
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe save(@RequestBody Clothe clothe) {
        return clotheServices.newClothe(clothe);
    }

    /**
     * Metodo para borrar un usuario
     *
     * @param clotheId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String clotheId) {
        clotheServices.deleteClothe(clotheId);
    }

    /**
     * Metodo para actualizar usuario
     *
     * @param clothe
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe updateUser(@RequestBody Clothe clothe) {
        return clotheServices.updateclone(clothe);
    }

    /**
     * Listar clones por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    @GetMapping("description/{desc}")
    public List<Clothe> cloneByDesc(@PathVariable("desc") String description) {
        return clotheServices.cloneByDesc(description);
    }

    /**
     * Listar clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    @GetMapping("price/{price}")
    public List<Clothe> cloneByPrice(@PathVariable("price") Double price) {
        return clotheServices.cloneByPrice(price);
    }


}
