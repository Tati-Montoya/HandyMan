package com.example.HandyMan.repository;

import com.example.HandyMan.dto.PostDataDTO;

import java.util.List;

public interface ITecnicoRepository {

    List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception;

    List postHorasTrabajadas(PostDataDTO post) throws Exception;

    List getTotalHorasDeLaSemana(String idTecnico, int numSemana) throws Exception;
}
