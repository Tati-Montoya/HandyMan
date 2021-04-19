package com.example.HandyMan.Repository;

import com.example.HandyMan.DTO.PostDataDto;

import java.util.List;

public interface ITecnicoRepository {

    List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception;

    List postHorasTrabajadas(PostDataDto post) throws Exception;

    int getTotalHoras(String idTecnico, int numSemana) throws Exception;
}
