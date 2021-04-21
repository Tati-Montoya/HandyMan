package com.example.HandyMan.Repository;


import com.example.HandyMan.DTO.PostDataDto;
import com.example.HandyMan.DTO.ResponseDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TecnicoRepositoryIMPL implements ITecnicoRepository {

    private final String consultarHoras =
            "SELECT TS.id_tecnico, S.num_semana, SUM(THT.horas_normales_extra) as horas_normales_extra, \n" +
            "SUM(THT.horas_dominicales) as horas_dominicales, SUM(THT.horas_nocturnas_extra) as horas_nocturnas_extra, \n" +
            "SUM(THT.horas_normales) as horas_normales, SUM(THT.horas_nocturnas) as horas_nocturnas, \n" +
            "SUM(THT.horas_dominicales_extra) as horas_dominicales_extra, SUM(THT.total_horas) as total_horas\n" +
            "FROM \n" +
            "total_horas_trabajadas THT \n" +
            "INNER JOIN dia D ON THT.id_total_horas = D.id_dia\n" +
            "INNER JOIN semana S ON D.id_dia = S.id_semana\n" +
            "INNER JOIN tecnico_servicio TS ON S.id_semana = TS.id_semana\n" +
            "WHERE id_tecnico = :id_tecnico AND num_semana = :num_semana";

    private final String totalHoraSemana = "SELECT SUM(THT.total_horas) AS total_horas\n" +
            "FROM \n" +
            "total_horas_trabajadas THT\n" +
            "INNER JOIN dia D ON THT.id_total_horas = D.id_dia\n" +
            "LEFT JOIN semana S ON D.id_dia = S.id_semana\n" +
            "LEFT JOIN tecnico_servicio TS ON S.id_semana = TS.id_semana\n" +
            "WHERE id_tecnico = :id_tecnico AND num_semana = :num_semana";

    private final String postHoras = "BEGIN;\n" +
            "INSERT INTO servicio (id_tipo_servicio, id_servicio) \n" +
            "VALUES ((SELECT MAX(id_tipo_servicio) FROM tipo_servicio) + 1, :id_servicio);\n" +
            "INSERT INTO semana (num_semana) \n" +
            "VALUES (:num_semana);\n" +
            "INSERT INTO dia (num_dia_semana) \n" +
            "VALUES (:num_dia_semana);\n" +
            "INSERT INTO total_horas_trabajadas  \n" +
            "(\n" +
            "hora_inicio, hora_fin, horas_normales, horas_nocturnas,\n" +
            "horas_dominicales, horas_normales_extra, horas_nocturnas_extra,\n" +
            "horas_dominicales_extra, total_horas\n" +
            ")\n" +
            " VALUES\n" +
            "(\n" +
            ":hora_inicio,\n" +
            ":hora_fin,\n" +
            ":horas_normales,\n" +
            ":horas_nocturnas,\n" +
            ":horas_dominicales,\n" +
            ":horas_normales_extra,\n" +
            ":horas_nocturnas_extra,\n" +
            ":horas_dominicales_extra,\n" +
            ":total_horas\n" +
            ");\n" +
            "INSERT INTO tecnico_servicio (id_tecnico, id_servicio, id_semana) \n" +
            "VALUES\n" +
            "(\n" +
            ":id_tecnico,\n" +
            "(SELECT id_servicio FROM servicio ORDER by id_servicio ASC LIMIT 1),\n" +
            "(SELECT MAX(id_semana)  FROM semana)\n" +
            ");\n" +
            "COMMIT;";

    @Autowired
    private EntityManager em;

    @Override
    public List getHorasTrabajadas(String idTecnico, int numSemana) throws Exception {
        try {
            Query query = em.createNativeQuery(consultarHoras, ResponseDataDto.class);
            query.setParameter("id_tecnico", idTecnico);
            query.setParameter("num_semana", numSemana);

            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error en el método getHorasTrabajadas: " + e);
        }
    }

    @Override
    public List postHorasTrabajadas(PostDataDto post) throws Exception {
        try {
            Query query = em.createNativeQuery(postHoras);
            query.setParameter("id_servicio", post.getId_servicio());
            query.setParameter("num_semana", post.getNum_semana());
            query.setParameter("num_dia_semana", post.getNum_dia_semana());
            query.setParameter("hora_inicio", post.getHora_inicio());
            query.setParameter("hora_fin", post.getHora_fin());
            query.setParameter("horas_normales", post.getHoras_normales());
            query.setParameter("horas_nocturnas", post.getHoras_nocturnas());
            query.setParameter("horas_dominicales", post.getHoras_dominicales());
            query.setParameter("horas_normales_extra", post.getHoras_normales_extra());
            query.setParameter("horas_nocturnas_extra", post.getHoras_nocturas_extra());
            query.setParameter("horas_dominicales_extra", post.getHoras_dominicales_extra());
            query.setParameter("total_horas", post.getTotal_horas());
            query.setParameter("id_tecnico", post.getId_tecnico());

//            return query.getResultList();
            return getHorasTrabajadas(post.getId_tecnico(), post.getNum_semana());
        } catch (Exception e) {
            throw new Exception("Error ejecutando consulta de post: " + e);
        }
    }

    //@Override
//    public int getTotalHoras(String idTecnico, int numSemana) throws Exception {
//        try {
//            Query query = em.createNativeQuery(totalHoraSemana);
//            query.setParameter("id_tecnico",idTecnico);
//            query.setParameter("num_semana",numSemana);
//
//            return query.getFirstResult();
//        }catch (Exception e){
//            throw new Exception("Error en metodo getTotalHoras: " + e);
//        }
//    }
}
