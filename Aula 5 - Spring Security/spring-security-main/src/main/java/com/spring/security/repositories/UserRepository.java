package com.spring.security.repositories;

import com.spring.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    //Aqui criamos esse método findByLogin, pois os métodos CRUD do JPA não possuem
    //essa funcionalidade de achar pelo login
    UserDetails findByLogin(String role);
}
