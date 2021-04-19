package com.example.HandyMan.DTO;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Immutable
public class PostDataDto implements Serializable {

    private static final long serialVersionUID = -8832261300645389472L;

    @Id
    @Column(name = "id_servicio")
    private  String id_servicio;

    @Column(name = "num_semana")
    private int num_semana;

    @Column(name = "num_dia_semana")
    private int num_dia_semana;

    @Column(name = "hora_inicio")
    private Date hora_inicio;

    @Column(name = "hora_fin")
    private Date hora_fin;

    @Column(name = "horas_normales")
    private int horas_normales;

    @Column(name = "horas_nocturnas ")
    private int horas_nocturnas;

    @Column(name = "horas_dominicales")
    private int horas_dominicales;

    @Column(name = "horas_normales_extra")
    private int horas_normales_extra;

    @Column(name = "horas_nocturnas_extra")
    private int horas_nocturas_extra;

    @Column(name = "horas_dominicales_extra")
    private int horas_dominicales_extra;

    @Column(name = "total_horas")
    private int total_horas;

    @Column(name = "id_tecnico")
    private String id_tecnico;

    @Column(name = "id_semana")
    private int id_semana;


    public int getNum_semana() {
        return num_semana;
    }

    public void setNum_semana(int num_semana) {
        this.num_semana = num_semana;
    }

    public int getNum_dia_semana() {
        return num_dia_semana;
    }

    public void setNum_dia_semana(int num_dia_semana) {
        this.num_dia_semana = num_dia_semana;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
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

    public int getHoras_dominicales() {
        return horas_dominicales;
    }

    public void setHoras_dominicales(int horas_dominicales) {
        this.horas_dominicales = horas_dominicales;
    }

    public int getHoras_normales_extra() {
        return horas_normales_extra;
    }

    public void setHoras_normales_extra(int horas_normales_extra) {
        this.horas_normales_extra = horas_normales_extra;
    }

    public int getHoras_nocturas_extra() {
        return horas_nocturas_extra;
    }

    public void setHoras_nocturas_extra(int horas_nocturas_extra) {
        this.horas_nocturas_extra = horas_nocturas_extra;
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

    public int getId_semana() {
        return id_semana;
    }

    public void setId_semana(int id_semana) {
        this.id_semana = id_semana;
    }
}
