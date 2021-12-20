package com.retos.services;

import com.retos.model.Clothe;
import com.retos.repository.crud.ClotheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @ autor Martinez
 **/
@Service
public class ClotheServices {
    /**
     * Atributo repositorio
     */
    private final ClotheRepository clotheRepository;

    public ClotheServices(ClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    /**
     * Metodo para obtener todos los usuarios
     *
     * @return
     */
    public List<Clothe> getAll() {
        return clotheRepository.findAll();
    }

    /**
     * Metodo para guardar un Clone
     *
     * @param clothe
     * @return
     */
    public Clothe newClothe(Clothe clothe) {

        if ( clothe.getReference() != null && clothe.getCategory() != null &&
                clothe.getSize() != null && clothe.getDescription() != null && clothe.getPrice() != null &&
                clothe.getAvailability() != null && clothe.getQuantity() != null && clothe.getPhotography() != null) {
            return clotheRepository.save(clothe);
        }
        return clothe;
    }

    /**
     * Metodo para eliminar Clone
     *
     * @param clotheReference
     */

    public void  deleteClothe(String clotheReference) {
        Optional<Clothe> clothe = clotheRepository.findById(clotheReference);
        if (clothe.isPresent()) {
            clotheRepository.deleteById(clotheReference);
        }

    }

    /**
     * Método para actualizar clone
     *
     * @param clothe
     * @return
     */
    public Clothe updateclone(Clothe clothe) {
        if (clothe.getReference() != null) {
            Optional<Clothe> exist = clotheRepository.findById(clothe.getReference());
            if (clothe.getSize() != null) {
                exist.get().setSize(clothe.getSize());
            }
            if (clothe.getReference() != null) {
                exist.get().setReference(clothe.getReference());
            }
            if (clothe.getReference() != null) {
                exist.get().setReference(clothe.getReference());
            }
            if (clothe.getDescription() != null) {
                exist.get().setDescription(clothe.getDescription());
            }
            if (clothe.getPrice() != null) {
                exist.get().setPrice(clothe.getPrice());
            }
            if (clothe.getAvailability() != null) {
                exist.get().setAvailability(clothe.getAvailability());
            }
            if (clothe.getQuantity() != null) {
                exist.get().setQuantity(clothe.getQuantity());
            }
            if (clothe.getPhotography() != null) {
                exist.get().setPhotography(clothe.getPhotography());
            }
            return clotheRepository.save(exist.get());
        }
        return clothe;
    }

    /**
     * Metodo para obtener y retornar un registro de documento de producto
     * por el valor de su atributo 'Reference', hacia el metodo 'getCloneByReference' del
     * CloneRepository
     *
     * @param Reference
     * @return
     */
    public Optional<Clothe> getClotheByReference(String Reference) {
        return clotheRepository.findById(Reference);
    }

    /**
     * Listar Clones por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    public List<Clothe> cloneByDesc(String description) {
        return clotheRepository.findClotheByDescriptionRegex("(?i)" + description );
    }

    /**
     * Listar Clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    public List<Clothe> cloneByPrice(Double price) {
        return clotheRepository.findClotheByPriceIsLessThanEqual(price);
    }
}


