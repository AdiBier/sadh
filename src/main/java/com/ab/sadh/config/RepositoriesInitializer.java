package com.ab.sadh.config;

import com.ab.sadh.model.Mission;
import com.ab.sadh.model.Product;
import com.ab.sadh.model.Users;
import com.ab.sadh.repository.MissionsRepository;
import com.ab.sadh.repository.ProductsRepository;
import com.ab.sadh.repository.UsersRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.List;

@Configuration
public class RepositoriesInitializer {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private MissionsRepository missionsRepository;

//    @Bean
//    InitializingBean initializingBean() { // TODO sprawdzić
//        return () -> {
//            if (usersRepository.findAll().isEmpty() == true) {
//                try {
//                    long startDateLong = 1584064229;
//                    Timestamp startDate = new Timestamp(startDateLong * 1000);
//                    long finishDateLong = 1589334629;
//                    Timestamp finish = new Timestamp(finishDateLong * 1000);
//
//                    Users user1 = new Users();
//                    user1.setEmail("firstUser@gmail.com");
//                    user1.setName("Janusz");
//                    user1.setSurname("Kowalki");
//                    user1.setPassword(passwordEncoder.encode("user"));
//                    user1.setPhone("789456123");
//                    user1.setRole("CUSTOMER");
//
//                    Users admin1 = new Users();
//                    admin1.setEmail("firstAdmin@gmail.com");
//                    admin1.setName("Juliusz");
//                    admin1.setSurname("Cesar");
//                    admin1.setPassword(passwordEncoder.encode("admin"));
//                    admin1.setPhone("722999111");
//                    admin1.setRole("ADMIN");
//
//
//
//                    Product product1 = new Product();
//                    product1.setProductAcquisitionDate(startDate);
////                    product1.setCoords(1,2);
//                    product1.setPrice(30.0);
//                    product1.setProductUrl("url");
//
//
//                    Mission mission1 = new Mission();
//                    mission1.setName("First Best Mission");
//                    mission1.setImageType("HYPERSPECTRAL");
//                    mission1.setStartDate(startDate);
//                    mission1.setFinishDate(finish);
//                    mission1.setUser(user1);
//                    mission1.setProducts((List<Product>) product1);
//                    missionsRepository.save(mission1);
//
//                    product1.setMission(mission1);
//                    product1.setUser(user1);
//                    productsRepository.save(product1);
//
//                    usersRepository.save(user1);
//                    usersRepository.save(admin1);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        };
//    }
}
