package com.example.HandyMan.Service;

import java.util.Date;
import java.util.List;

public interface ITecnicoService {

    public List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception;

    public List postHorasTrabajadas(Date horaInicio, Date horaFin, String idTecnico, String idServicio, int totalHorasSemana) throws Exception;

    public List getTotalHorasDeLaSemana(String idTecnico, int numSemana) throws Exception;

}
