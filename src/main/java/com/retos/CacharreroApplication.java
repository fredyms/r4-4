package com.retos;

import com.retos.repository.crud.ClotheRepository;
import com.retos.repository.crud.OrderRepository;
import com.retos.repository.crud.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ autor Paola Martinez
 **/
@SpringBootApplication
public class CacharreroApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacharreroApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClotheRepository clotheRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        clotheRepository.deleteAll();
        orderRepository.deleteAll();
    }

}
