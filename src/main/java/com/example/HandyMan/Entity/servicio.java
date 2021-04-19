package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "servicio")
public class servicio implements Serializable {
    private static final long serialVersionUID = 8819344941133580271L;

    @Id
    @Column(name = "idServicio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idServicio;

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
}
