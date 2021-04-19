package com.example.HandyMan.Service;

import com.example.HandyMan.Business.CalculadoraDeHoras;
import com.example.HandyMan.DTO.PostDataDto;
import com.example.HandyMan.Repository.ITecnicoRepository;
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
    public List postHorasTrabajadas(Date horaInicio, Date horaFin, String idTecnico, String idServicio) throws Exception {

        PostDataDto post = new PostDataDto();

        post.setId_servicio(idServicio);
        post.setId_tecnico(idTecnico);
        post.setHora_inicio(horaInicio);
        post.setHora_fin(horaFin);
        post.setNum_semana(CalculadoraDeHoras.calculateWeekOfYear(horaInicio));
        post.setNum_dia_semana(CalculadoraDeHoras.calculateDayOfWeek(horaInicio));
        post.setHoras_normales(CalculadoraDeHoras.calculateHourPerService(horaInicio,horaFin));
        post.setHoras_nocturnas(CalculadoraDeHoras.calculateNightHour(horaInicio,horaFin));
        post.setHoras_dominicales(0);
        post.setHoras_normales_extra(0);
        post.setHoras_nocturas_extra(0);
        post.setHoras_dominicales_extra(0);
        int semana = CalculadoraDeHoras.calculateWeekOfYear(horaInicio);
        post.setTotal_horas(CalculadoraDeHoras.calculateHoursPerWeek(idTecnico, semana));
        post.setId_semana(0);

        return tecnicoRepository.postHorasTrabajadas(post);
    }

}
