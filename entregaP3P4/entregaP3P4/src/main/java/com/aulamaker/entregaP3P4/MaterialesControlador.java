package com.aulamaker.entregaP3P4;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

//Creamos una matriz donde guardamos los siguientes datos : codigo,nombre y descripcion.
@Controller
public class MaterialesControlador {
    private static final String [][] MATERIALES = {
            {"PORTATIL", "Ordenador portatil", "Incluye un cargador y una funda."},
            {"MICRO", "Kit de microcontrolador", "Incluye una placa y un cable USB."},
            {"CAMARA", "Camara de documentacion", "Incluye un soporte de mesa."}
    };

    //Creamos un metodo llamado "buscarMaterial" para nos devuelva la fila del producto y si no existe nos devuelve null.
    private String[] buscarMaterial(String codigo){
        for (String[] material : MATERIALES){
            if (material[0].equals(codigo)){
                return material;
            }
        }
        return null;
    }

    //Llamaos al "GetMapping" para pasar nuestra array a la vista controladora.
    @GetMapping("/")
    public String catalogo (Model model){
        model.addAttribute("materiales", MATERIALES);
        return "catalogo";
    }

    //Muestra la ficha del material segun tenga el codigo.
    @GetMapping("/materiales/{codigo}")
    public String ficha(@PathVariable String codigo,
                        @RequestParam(defaultValue = "general") String turno,
                        Model model) {
        //Busca el material con el metodo creado mediante el codigo suyo.
        String[] material = buscarMaterial(codigo);
        //Si el material en este caso no existe o es nulo, devuelve el error 404.
        if (material == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        //Envia los datos del material.
        model.addAttribute("material", material);
        model.addAttribute("turno", turno);
        return "ficha";
    }


}
