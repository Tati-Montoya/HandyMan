package com.example.HandyMan.dto;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
public class RequestDataDTO {


    @Id
    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "id_servicio")
    private String id_servicio;

    @Column(name = "hora_inicio")
    private String hora_inicio;

    @Column(name = "hora_fin")
    private String hora_fin;

    @Column(name = "num_semana")
    private int num_semana;

    public String getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getNum_semana() {
        return num_semana;
    }

    public void setNum_semana(int num_semana) {
        this.num_semana = num_semana;
    }
}
