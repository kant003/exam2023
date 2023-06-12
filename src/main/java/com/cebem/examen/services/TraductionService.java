package com.cebem.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.examen.models.TranslationModel;

@Service
public class TraductionService {
    @Autowired
    RestTemplate restTemplate;

    public String translate(String frase){
        final String url = "https://api.mymemory.translated.net/get?q="+frase+"&langpair=en|es";
        TranslationModel datos = restTemplate.getForObject(url, TranslationModel.class);
        return datos.responseData.translatedText;
    }
}
