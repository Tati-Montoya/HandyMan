package com.example.HandyMan.Repository;

import com.example.HandyMan.DTO.PostDataDTO;

import java.util.List;

public interface ITecnicoRepository {

    List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception;

    List postHorasTrabajadas(PostDataDTO post) throws Exception;

    List getTotalHorasDeLaSemana(String idTecnico, int numSemana) throws Exception;
}
