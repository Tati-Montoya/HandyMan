package com.example.HandyMan.Controller;

import com.example.HandyMan.DTO.ResponseDataDto;
import com.example.HandyMan.Service.ITecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/tecnico-servicio")
public class TecnicoController {

    @Autowired
    ITecnicoService tecnicoServicio;

    @GetMapping("/total-horas")
    public ResponseEntity getHoras(@RequestParam String idTecnico, @RequestParam int numSemana) throws Exception {

        var response = tecnicoServicio.getHorasTrabajadas(idTecnico, numSemana);

        if (response == null || response.isEmpty() || response.get(0) == null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDataDto>());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/guardar-horas")
    public ResponseEntity postHoras(@RequestParam String fechaInicio, @RequestParam String fechaFin,
                                    @RequestParam String idTecnico, @RequestParam String idServicio) throws Exception {
        DateFormatter format = new DateFormatter();
        Date fInicio = format.formatDate(fechaInicio);
        Date fFin = format.formatDate(fechaFin);

        var response = tecnicoServicio.postHorasTrabajadas(fInicio, fFin, idTecnico, idServicio);

        return ResponseEntity.status(HttpStatus.OK).body(response);
//        if (response == null || response.isEmpty() || response.get(0) == null){
//            return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<ResponseDataDto>());
//        }else{
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        }

    }
}
