package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tecnico_servicio")
public class tecnico_servicio implements Serializable {
    private static final long serialVersionUID = -5547258536060485433L;

    @Id
    @Column(name = "idTecnicoservicio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTecnicoservicio;

    public int getIdTecnicoservicio() {
        return idTecnicoservicio;
    }

    public void setIdTecnicoservicio(int idTecnicoservicio) {
        this.idTecnicoservicio = idTecnicoservicio;
    }
}
