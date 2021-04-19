package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dia")
public class dia implements Serializable {
    private static final long serialVersionUID = 2818907113693696156L;

    @Id
    @Column(name = "idDia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDia;

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }
}
