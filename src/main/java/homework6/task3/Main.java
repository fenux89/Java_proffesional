package homework6.task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        LocalDate oldDate = LocalDate.of(2021, 4, 28);
        LocalDate now = LocalDate.now();

        diffDate(oldDate , now);

  //      System.out.println("Вам исполнилось " + votTime(gc, gc2).get(Calendar.YEAR) + " лет, " + votTime(gc, gc2).get(Calendar.MONTH) + " месяца " + votTime(gc, gc2).get(Calendar.DAY_OF_MONTH) + " дней ") ;

    }
    public static void diffDate(LocalDate a, LocalDate b){
        Period diff = Period.between(a, b);
        System.out.printf("Вам исполнилось %d лет, %d месяца %d дней",
                diff.getYears(), diff.getMonths(), diff.getDays());
    }

//    public static Calendar votTime(GregorianCalendar a, GregorianCalendar b) throws ParseException {
//        Calendar kl = new GregorianCalendar();
//        int yaer, month, day;
//        yaer = a.get(Calendar.YEAR)-b.get(Calendar.YEAR);
//        month = a.get(Calendar.MONTH) - b.get(Calendar.MONTH);
//        day = a.get(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH);
 //       long d = a.getTime()-b.getTime();                             // Не понмимаю почему не работает срока, в интернете много примеров где это работает
//        kl.set(Calendar.YEAR, yaer);
//        kl.set(Calendar.MONTH, month);
//        kl.set(Calendar.DAY_OF_MONTH, day);
//
//        return kl;
//    }


}
