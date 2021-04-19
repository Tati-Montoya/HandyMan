package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "semana")
public class semana implements Serializable {
    private static final long serialVersionUID = -7371946297659283531L;

    @Id
    @Column(name = "idSemana")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSemana;

    public int getIdSemana() {
        return idSemana;
    }

    public void setIdSemana(int idSemana) {
        this.idSemana = idSemana;
    }
}
