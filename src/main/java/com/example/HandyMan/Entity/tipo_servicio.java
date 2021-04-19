package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_servicio")
public class tipo_servicio implements Serializable {
    private static final long serialVersionUID = 5290058183943741312L;

    @Id
    @Column(name = "idTipoServicio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipoServicio;

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }
}
