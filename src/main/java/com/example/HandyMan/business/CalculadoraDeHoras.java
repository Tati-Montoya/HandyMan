package com.example.HandyMan.business;

import com.example.HandyMan.repository.TecnicoRepositoryIMPL;

import java.util.Calendar;
import java.util.Date;

public class CalculadoraDeHoras {

    static Calendar cal = Calendar.getInstance();
    private static TecnicoRepositoryIMPL tecnicoRepository;

    public static int extractHourForDate(Date date) {
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int calculateHourPerService(Date start, Date end) {
        if (extractHourForDate(end) > extractHourForDate(start)) {
            return extractHourForDate(end) - extractHourForDate(start);
        }
        return 0;
    }

    public static int calculateNightHour(Date start, Date end) {
        int startHour = extractHourForDate(start);
        int endHour = extractHourForDate(end);

        int startNight = 20;
        int endNigth = 7;
        int midNigth = 23;
        //madrugada-madrugada
        if (startHour <= endNigth && endHour <= endNigth) {
            return endHour - startHour;
            //madrugada-dia
        }else if(startHour < endNigth && endHour < startNight){
            return endNigth - startHour;
            //dia-noche
        } else if(startHour > endNigth && endHour >startNight){
            return endHour-startNight;
            //noche-noche
        }else if(startHour >= startNight && endHour > startNight){
            return endHour-startHour;
            //madrugada-noche
        }else if(startHour<endNigth && endHour>startNight){
            return (endNigth-startHour)+(endHour-startNight);
        }else {return 0;}
    }

    public static int calculateDayOfWeek(Date startDate) {
        cal.setTime(startDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int calculateWeekOfYear(Date startDate) {
        cal.setTime(startDate);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int calculateHourSunday(Date startDate, Date endDate) {
        int day = calculateDayOfWeek(endDate);
        if (day == 7) {
            return calculateHourPerService(startDate, endDate);
        } else {
            return 0;
        }
    }

    public static int calculateExtraHours(int TotalHoras) {
        int horasLaborales = 48;
        if (TotalHoras > horasLaborales) {
            return TotalHoras - horasLaborales;
        } else {
            return 0;
        }
    }

    public static int calculateSundayExtraHours(Date date, int totalHoras) {
        int day = calculateDayOfWeek(date);
        int horasLaborales = 48;
        if (day == 7 && totalHoras > horasLaborales) {
            return calculateExtraHours(totalHoras);
        } else {
            return 0;
        }
    }

    public static int calculateNigthExtraHours(Date start, Date end, int totalHoras) {
        int horasLaborales = 48;
        if (calculateNightHour(start, end) != 0 && totalHoras > horasLaborales) {
            return calculateExtraHours(totalHoras);
        } else {
            return 0;
        }
    }
}