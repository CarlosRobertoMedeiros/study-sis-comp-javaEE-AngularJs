package br.com.roberto.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    public static LocalDate stringToDate(String dataEmString){
        String dataInterna = dataEmString.substring(0,10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dataInterna,formatter);
        return date;
    }

    public static String dateToString(LocalDate data){
        return Integer.toString(data.getYear())
                +"/"+Integer.toString(data.getMonthValue())
                +"/"+Integer.toString(data.getDayOfMonth());
    }

}
