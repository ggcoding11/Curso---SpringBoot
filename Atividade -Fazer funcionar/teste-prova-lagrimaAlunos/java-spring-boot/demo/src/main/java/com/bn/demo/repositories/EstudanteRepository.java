package com.bn.demo.repositories;

import com.bn.demo.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long>  {

}
