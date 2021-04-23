package com.example.HandyMan.DTO;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Immutable
public class ResponseDataDTO implements Serializable {
    private static final long serialVersionUID = -3728772549794683965L;

    @Id
    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "num_semana")
    private int num_semana;

    @Column(name = "horas_normales")
    private int horas_normales;

    @Column(name = "horas_normales_extra")
    private int horas_normales_extra;

    @Column(name = "horas_dominicales")
    private int horas_dominicales;

    @Column(name = "horas_nocturnas")
    private int horas_nocturnas;

    @Column(name = "horas_nocturnas_extra")
    private int horas_nocturnas_extra;

    @Column(name = "horas_dominicales_extra")
    private int horas_dominicales_extra;

    @Column(name = "total_horas")
    private int total_horas;

    public String getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public int getNum_semana() {
        return num_semana;
    }

    public void setNum_semana(int num_semana) {
        this.num_semana = num_semana;
    }

    public int getHoras_normales_extra() {
        return horas_normales_extra;
    }

    public void setHoras_normales_extra(int horas_normales_extra) {
        this.horas_normales_extra = horas_normales_extra;
    }

    public int getHoras_dominicales() {
        return horas_dominicales;
    }

    public void setHoras_dominicales(int horas_dominicales) {
        this.horas_dominicales = horas_dominicales;
    }

    public int getHoras_nocturnas_extra() {
        return horas_nocturnas_extra;
    }

    public void setHoras_nocturnas_extra(int horas_nocturnas_extra) {
        this.horas_nocturnas_extra = horas_nocturnas_extra;
    }

    public int getHoras_dominicales_extra() {
        return horas_dominicales_extra;
    }

    public void setHoras_dominicales_extra(int horas_dominicales_extra) {
        this.horas_dominicales_extra = horas_dominicales_extra;
    }

    public int getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(int total_horas) {
        this.total_horas = total_horas;
    }

    public int getHoras_normales() {
        return horas_normales;
    }

    public void setHoras_normales(int horas_normales) {
        this.horas_normales = horas_normales;
    }

    public int getHoras_nocturnas() {
        return horas_nocturnas;
    }

    public void setHoras_nocturnas(int horas_nocturnas) {
        this.horas_nocturnas = horas_nocturnas;
    }
}
