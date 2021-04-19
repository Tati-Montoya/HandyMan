package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tecnico")
public class tecnico implements Serializable {
    private static final long serialVersionUID = 3765181898815770981L;

    @Id
    @Column(name = "id_tecnico")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_tecnico;

    public String getIdTecnico() {
        return id_tecnico;
    }

    public void setIdTecnico(String id_tecnico) {
        this.id_tecnico = id_tecnico;
    }
}
