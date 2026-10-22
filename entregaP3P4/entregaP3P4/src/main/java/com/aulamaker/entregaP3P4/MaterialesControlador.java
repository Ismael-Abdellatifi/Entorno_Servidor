package com.aulamaker.entregaP3P4;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    //Nos calcula cuanto dura el prestamo, y el chronoUnit calcula la diferencia entre las dos fechas.
    private long calcularDias(LocalDate recogida, LocalDate devolucion) {
        return ChronoUnit.DAYS.between(recogida, devolucion) + 1;
    }
    //Este metodo nos ayuda y responde las peticiones dirigidas a esta direccion.
    @GetMapping("/solicitud/nueva")
    //Metodo que muestra el formulario para crear una nueva solicitud como se ve en el metodo.
    public String nuevaSolicitud(Model model) {
        //Se crea un objeto vacio del formulario, y en la vista lo rellenaras los campos obligatorios.
        model.addAttribute("solicitud", new SolicitudPrestamoForm());
        //Añade la lista de materiales disponibles.
        model.addAttribute("materiales", MATERIALES);
        return "formulario";
    }

    //Este metodo nos ayuda para enviar los datos al formulario.
    @PostMapping("/solicitudes")
    //Con @valid nos valida las solicitudes y los campos para que valgan correctamente.
    //Con este metodo procesa los datos que introduce el usuario.
    public String procesarSolicitud(@Valid @ModelAttribute("solicitud") SolicitudPrestamoForm solicitud,
                                    BindingResult result,
                                    Model model) {

       //Si se cumple las dos condiciones, busca en este caso el material del catalogo.
        //Y si devuelve null, que no se ha encontrado.
        if (solicitud.getMaterial() != null && !solicitud.getMaterial().isBlank()
                && buscarMaterial(solicitud.getMaterial()) == null) {
            result.rejectValue("material", "material.desconocido",
                    "El material elegido no está en el catálogo.");
        }

        //Comrpueba las fechas que existen
        LocalDate recogida = solicitud.getFechaRecogida();
        LocalDate devolucion = solicitud.getFechaDevolucion();
        if (recogida != null && devolucion != null && devolucion.isBefore(recogida)) {
            result.rejectValue("fechaDevolucion", "fecha.incoherente",
                    "La devolución no puede ser anterior a la recogida.");
        }


        if (result.hasErrors()) {
            model.addAttribute("materiales", MATERIALES);
            return "formulario";
        }
        //Nos calcula la duracion del prestamos en dias.
        String[] material = buscarMaterial(solicitud.getMaterial());
        long dias = calcularDias(recogida, devolucion);
        long diasUnidad = dias * solicitud.getUnidades();

        model.addAttribute("nombreMaterial", material[1]);
        model.addAttribute("dias", dias);
        model.addAttribute("diasUnidad", diasUnidad);
        return "resultado";
    }

}
