package com.example.HandyMan.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class total_horas_trabajadas implements Serializable {
    private static final long serialVersionUID = 1874186070136980770L;

    @Id
    @Column(name = "idTotalHoras")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTotalHoras;

    public int getIdTotalHoras() {
        return idTotalHoras;
    }

    public void setIdTotalHoras(int idTotalHoras) {
        this.idTotalHoras = idTotalHoras;
    }
}
