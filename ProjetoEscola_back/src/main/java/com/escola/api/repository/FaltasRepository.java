package com.escola.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Faltas;
import com.escola.api.model.FaltasId;


public interface FaltasRepository extends JpaRepository<Faltas, FaltasId>{

}
