package com.example.HandyMan.controller;

import com.example.HandyMan.business.CalculadoraDeHoras;
import com.example.HandyMan.dto.RequestDataDTO;
import com.example.HandyMan.dto.ResponseDataDTO;
import com.example.HandyMan.service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/tecnico-servicio")
public class TecnicoController {

    @Autowired
    ITecnicoService tecnicoServicio;

    @GetMapping("/total-horas")
    public ResponseEntity getHoras(@RequestParam String idTecnico, @RequestParam int numSemana) throws Exception {

        var response = tecnicoServicio.getHorasTrabajadas(idTecnico, numSemana);

        if (response == null || response.isEmpty() || response.get(0) == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDataDTO>());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/guardar-horas")
    public ResponseEntity postHoras(@RequestBody RequestDataDTO requestPost) throws Exception {

        DateFormatter format = new DateFormatter();
        Date fInicio = format.formatDate(requestPost.getHora_inicio());
        Date fFin = format.formatDate(requestPost.getHora_fin());
        int horasSemana = 0;

        List totalHorasSemana = tecnicoServicio.getTotalHorasDeLaSemana(requestPost.getId_tecnico(), CalculadoraDeHoras.calculateWeekOfYear(fInicio));

        if (totalHorasSemana.get(0) != null) {
            horasSemana = Integer.parseInt(totalHorasSemana.get(0).toString());
        }

        var response = tecnicoServicio.postHorasTrabajadas(fInicio, fFin, requestPost.getId_tecnico(), requestPost.getId_servicio(), horasSemana);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
