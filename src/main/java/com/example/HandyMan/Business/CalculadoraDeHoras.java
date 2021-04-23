package com.example.HandyMan.Business;

import com.example.HandyMan.Repository.TecnicoRepositoryIMPL;

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
        Calendar calStart = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();

        calStart.setTime(start);
        calEnd.setTime(end);
        int startNight = 20;
        int endNigth = 7;
        int midNigth = 24;

        if (calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) <= midNigth
                || calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {
            if (calEnd.get(Calendar.HOUR_OF_DAY) <= midNigth)
                return calEnd.get(Calendar.HOUR_OF_DAY) - startNight; // dia - noche
            else { // dia - madrugada
                return (midNigth - calStart.get(Calendar.HOUR_OF_DAY)) + calEnd.get(Calendar.HOUR_OF_DAY);
            }
        } else if (calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {

            if (calEnd.get(Calendar.HOUR_OF_DAY) <= endNigth) {// noche-noche
                return (calEnd.get(Calendar.HOUR_OF_DAY) + 4) - (calStart.get(Calendar.HOUR_OF_DAY) - startNight); //20 - 24
            } else {
                return (endNigth - calStart.get(Calendar.HOUR_OF_DAY)) - (endNigth - calEnd.get(Calendar.HOUR_OF_DAY)); //0 - 7
            }

        } else if (calStart.get(Calendar.HOUR_OF_DAY) >= startNight && calEnd.get(Calendar.HOUR_OF_DAY) >= endNigth) {
            if (calStart.get(Calendar.HOUR_OF_DAY) <= midNigth && calStart.get(Calendar.HOUR_OF_DAY) >= startNight) {
                return (midNigth - calStart.get(Calendar.HOUR_OF_DAY)); // noche - dia
            } else {
                return (endNigth - calStart.get(Calendar.HOUR_OF_DAY)); // madrugada - dia
            }
        } else {
            return 0;
        }
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