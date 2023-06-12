package com.cebem.examen.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.examen.models.QuejaModel;
import com.cebem.examen.repositories.QuejaRepository;

@Service
public class QuejaService2 {
    @Autowired
    QuejaRepository quejaRepository;


    public QuejaModel create(QuejaModel queja){
        return quejaRepository.save(queja);
    }

    public ArrayList<QuejaModel> getAll(){
        return (ArrayList<QuejaModel>) quejaRepository.findAll();
    }

    public ArrayList<QuejaModel> getByName(String name){
        return quejaRepository.findByName(name);
    }
}
