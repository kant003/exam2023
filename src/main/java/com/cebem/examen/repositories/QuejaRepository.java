package com.cebem.examen.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cebem.examen.models.QuejaModel;

@Repository
public interface QuejaRepository extends JpaRepository<QuejaModel, Long> {
    ArrayList<QuejaModel> findByName(String name);
}
