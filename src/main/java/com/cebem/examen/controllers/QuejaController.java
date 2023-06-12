package com.cebem.examen.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.sql.Timestamp;    
import java.util.Date;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cebem.examen.models.QuejaModel;
import com.cebem.examen.services.QuejaService2;

@Controller
public class QuejaController {
    @Autowired
    QuejaService2 quejaService;
    
    @RequestMapping("/quejas/guardarForm")
    public String guardarForm(){
        return "guardarForm";
    }

    @PostMapping("/guardar")
    public String guardar(Model model, @RequestParam Map<String, String> body){
        String name = body.get("name");
        String text = body.get("text");
        QuejaModel nuevaQueja = new QuejaModel();
        nuevaQueja.name = name;
        nuevaQueja.text = text;
        Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        nuevaQueja.createdAt = ts;
        quejaService.create(nuevaQueja);

        ArrayList<QuejaModel> quejas = quejaService.getAll();
        model.addAttribute("quejas", quejas);
        return "quejasList";
    }
    
    @RequestMapping("/quejas")
    public String listar(Model model){
        ArrayList<QuejaModel> quejas = quejaService.getAll();
        model.addAttribute("quejas", quejas);
        return "quejasList";
    }

    @RequestMapping("/quejas/{name}")
    public String listarPorNombre(Model model, @PathVariable String name){
        ArrayList<QuejaModel> quejas = quejaService.getByName(name);
        model.addAttribute("quejas", quejas);
        return "quejasList";
    }

}
