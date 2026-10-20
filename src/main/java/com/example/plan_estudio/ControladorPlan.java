package com.example.plan_estudio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorPlan {
    @GetMapping("/")
    public String plan(
            @RequestParam(defaultValue = "estudiante")String nombre,
            Model model){
        List<String> asignaturas = List.of("Programacion","Base de datos","Lenguajes de marcas");
        List<Integer> duraciones = List.of(25, 40, 30);

        int totalMinutos = duraciones.stream().mapToInt(Integer::intValue).sum();

        model.addAttribute("nombre", nombre);
        model.addAttribute("titulo", "Mi plan de estudio de hoy");
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("duraciones", duraciones);
        model.addAttribute("totalMinutos", totalMinutos);
        return "plan.html";
    }

}
