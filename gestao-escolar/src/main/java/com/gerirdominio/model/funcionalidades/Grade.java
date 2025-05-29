package com.gerirdominio.model.funcionalidades;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private int id;
    private List<Aula> aulas;
    
    public Grade(int id) {
        this.id = id;
        this.aulas = new ArrayList<>();
    }
    
    //Métodos a criar: adicionarAula, removerAula, consultarGrade
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Grade #" + id + 
        "\nAulas: " + aulas.toString();
    }
}