package com.example.spring_museosapiconapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
/*
Crear una api que muestre el nombre de todos los museos de Argentina, con su dirección y teléfono.

https://www.cultura.gob.ar/api/v2.0/museos/

 */

@RestController
public class MuseoController {

    @GetMapping("museos")
    public List<Museo> listarMuseos(){

        RestTemplate apiMuseos = new RestTemplate();

        ListaMuseos listaMuseos = apiMuseos.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", ListaMuseos.class);

        return listaMuseos.getResults();
    }

    @GetMapping("museos/nombres")
    public List<String> listarNombresMuseos(){
        RestTemplate apiMuseos = new RestTemplate();

        ListaMuseos listaMuseos = apiMuseos.getForObject("https://www.cultura.gob.ar/api/v2.0/museos/", ListaMuseos.class);

        return listaMuseos.getResults().stream().map(museo -> museo.getNombre()).toList();
    }

}