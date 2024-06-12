package pages;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.function.Predicate;

public class Jotter {


        public static void main(String[] args) throws ParseException {
            /*
            String dateString = "August 20 2015";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
            LocalDate d = LocalDate.parse("2024-05-20");
            System.out.println("year:: " + d.getMonthValue());


            String monthName = "2024-May"; // Your month name
            Date date = new SimpleDateFormat("yyyy-MMMM", Locale.ENGLISH).parse(monthName);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            int monthValue = cal.get(Calendar.MONTH) + 1; // Add 1 to get the correct month value
            System.out.println("Month value: " + monthValue);
            System.out.println("Year:: " + cal.get(Calendar.YEAR));
//            LocalDate localDate = LocalDate.parse(dateString, formatter);
//            System.out.println(localDate.getMonth()); // Output: 2015-08-20

             */
            System.out.println(test((i) -> {return i == 5;}));

        }
        private static boolean test(Predicate<Integer> k) {
            return k.test(7);
        }



}
