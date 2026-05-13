package com.spring.security.models;

import com.spring.security.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String login;
   private String password;
   private UserRole role;

   //Daqui pra baixo é Spring Security
   //Aqui configuramos os perfis e suas permissões
   //Ex: no caso aqui, o admin ele tem autoridade tanto de ADMIN quanto do usuário comum (USER)

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      if(this.role == UserRole.ADMIN) return
              List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER"));
      else return  List.of(new SimpleGrantedAuthority("USER"));
   }

   @Override
   public String getUsername() {
      return login;
   }
}
