package com.repasojdbc.modelo;

import java.time.LocalDate;

public class ExcusaEntrega {
    private int id;
    private String alumno;
    private String curso;
    private String excusa;
    private int diasRetraso;
    private int credibilidad;
    private LocalDate fechaEntrega; // puede ser null
    private boolean aprobadaPorProfesor;
    private int nivelDrama;

    public ExcusaEntrega(int id, String alumno, String curso, String excusa, int diasRetraso,
                         int credibilidad, LocalDate fechaEntrega,
                         boolean aprobadaPorProfesor, int nivelDrama) {
        this.id = id;
        this.alumno = alumno;
        this.curso = curso;
        this.excusa = excusa;
        this.diasRetraso = diasRetraso;
        this.credibilidad = credibilidad;
        this.fechaEntrega = fechaEntrega;
        this.aprobadaPorProfesor = aprobadaPorProfesor;
        this.nivelDrama = nivelDrama;
    }

    public int getId() { return id; }
    public String getAlumno() { return alumno; }
    public String getCurso() { return curso; }
    public String getExcusa() { return excusa; }
    public int getDiasRetraso() { return diasRetraso; }
    public int getCredibilidad() { return credibilidad; }
    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public boolean isAprobadaPorProfesor() { return aprobadaPorProfesor; }
    public int getNivelDrama() { return nivelDrama; }

    @Override
    public String toString() {
        return String.format("#%d | %s | %s | retraso: %d d | cred: %d | drama: %d | entrega: %s | aprobada: %s",
                id, alumno, excusa, diasRetraso, credibilidad, nivelDrama,
                fechaEntrega == null ? "SIN ENTREGAR" : fechaEntrega,
                aprobadaPorProfesor ? "sí" : "no");
    }
}