package com.example.HandyMan.business;

import com.example.HandyMan.controller.DateFormatter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDeHorasTest {

    private DateFormatter dt = new DateFormatter();

    @Test
    public void testExtractHourForDateWhenReturnAnHour() throws ParseException {
        Date hora = dt.formatDate("2020-01-03T13:00");

        int response = CalculadoraDeHoras.extractHourForDate(hora);

        assertEquals(8, response);
    }

    @Test
    public void testExtractHourForDateWhenNotReturnACorrectHour() throws ParseException {
        Date hora = dt.formatDate("2020-01-03T10:00");

        int response = CalculadoraDeHoras.extractHourForDate(hora);

        assertNotEquals(8, response);
    }

    @Test
    public void testCalculateHourPerServiceWhenReturnHours() throws ParseException {
        Date inicio = dt.formatDate("2020-01-03T10:00");
        Date fin = dt.formatDate("2020-01-03T12:00");

        int response = CalculadoraDeHoras.calculateHourPerService(inicio, fin);

        assertEquals(2, response);
    }
}
