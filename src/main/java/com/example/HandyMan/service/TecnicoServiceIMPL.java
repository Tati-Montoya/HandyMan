package com.example.HandyMan.service;

import com.example.HandyMan.business.CalculadoraDeHoras;
import com.example.HandyMan.dto.PostDataDTO;
import com.example.HandyMan.repository.ITecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TecnicoServiceIMPL implements ITecnicoService {

    @Autowired
    private ITecnicoRepository tecnicoRepository;

    @Override
    public List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception {
        return tecnicoRepository.getHorasTrabajadas(idTecnico, numSemana);
    }

    @Override
    public List postHorasTrabajadas(Date horaInicio, Date horaFin, String idTecnico, String idServicio, int totalHorasSemana) throws Exception {

        PostDataDTO post = new PostDataDTO();

        post.setId_servicio(idServicio);
        post.setId_tecnico(idTecnico);
        post.setHora_inicio(horaInicio);
        post.setHora_fin(horaFin);
        post.setNum_semana(CalculadoraDeHoras.calculateWeekOfYear(horaInicio));
        post.setNum_dia_semana(CalculadoraDeHoras.calculateDayOfWeek(horaInicio));
        post.setHoras_normales(CalculadoraDeHoras.calculateHourPerService(horaInicio,horaFin));
        post.setHoras_nocturnas(CalculadoraDeHoras.calculateNightHour(horaInicio,horaFin));
        post.setHoras_dominicales(CalculadoraDeHoras.calculateHourSunday(horaInicio,horaFin));
        post.setHoras_normales_extra(CalculadoraDeHoras.calculateExtraHours(totalHorasSemana));
        post.setHoras_nocturas_extra(CalculadoraDeHoras.calculateNigthExtraHours(horaInicio,horaFin,totalHorasSemana));
        post.setHoras_dominicales_extra(CalculadoraDeHoras.calculateSundayExtraHours(horaInicio,totalHorasSemana));
        post.setTotal_horas(CalculadoraDeHoras.calculateHourPerService(horaInicio,horaFin));
        post.setId_tipo_servicio(2);

        return tecnicoRepository.postHorasTrabajadas(post);
    }

    @Override
    public List getTotalHorasDeLaSemana(String idTecnico, int numSemana) throws Exception {
        return tecnicoRepository.getTotalHorasDeLaSemana(idTecnico, numSemana);
    }

}
