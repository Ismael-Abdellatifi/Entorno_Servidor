package com.aulamaker.entregaP3P4;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//Clase que recoge los datos que tienen que introducir el usuario en el formulario.
public class SolicitudPrestamoForm {
    //Obligamos a que el nombre sea obligatorio y no se deje en blanco.
    @NotBlank(message = "El nombre es obligatorio.")
    //Limitamos un maximo de 60 caracteres.
    @Size (max = 60, message = "El nombre admite como maximo 60 caracteres.")
    private String nombre;

    //Obligamos a que el correo sea obligatorio y no se deje en blanco.
    @NotBlank (message = "El correo es obligatorio.")
    //Comprobamos que este en formato valido.
    @Email (message = "El formato del correo no es valido.")
    //Limitamos el correo a 120 caracteres.
    @Size (max = 120, message = "El correo admite como maximoi 120 caracteres")
    private String correo;

    //Obliga a seleccionar o introducir un material anteriores.
    @NotBlank (message = "Elige un material.")
    private String material;

    //Obligamos a que el usuario ponga siempre alguna unidad.
    @NotNull (message = "Indica las unididades.")
    //Cantidad minima 1.
    @Min(value = 1, message = "Minimo 1 unidad.")
    //Cantidad maxima 3.
    @Max(value = 3, message = "Maximo 3 unidades.")
    private Integer unidades;

    //Obligamos al usuario que indique una fecha de devolucion.
    @NotNull(message = "La fecha de recogida obligatoria.")
    //Ponemos fechas futuras o la de hoy por ejemplo.
    @FutureOrPresent(message = "La recogida deber ser hoy o una fecha futura.")

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaDevolucion;

    //Obligamos al usuario escribir el motivo del prestamo.
    @NotBlank(message = "El motivo es obligatorio.")
    //El motivo va entre 30 a 300 caracteres.
    @Size (min = 30, max= 300, message = "El motivo debe tener entre 20 y 200 caracteres.")
    private String motivo;

    //Esto le indicara al usuario un error si no pone ninguna fecha.
    @NotNull(message = "La fecha de recogida es obligatoria.")
    //No permite que tengas fecha anterior a la actual y comprueba que sea hoy o fecha futura.
    @FutureOrPresent(message = "La recogida debe ser de hoy a futuros dias.")
    //Establece el formato de fecha que se debe utilizar.
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecogida;

    //Obligamos al usuario que acepte las normas para poder enviar los formularios.
    @AssertTrue (message = "Aceptò las normas y condiciones.")
    private boolean normas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isNormas() {
        return normas;
    }

    public void setNormas(boolean normas) {
        this.normas = normas;
    }

    public LocalDate getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(LocalDate fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }
}
