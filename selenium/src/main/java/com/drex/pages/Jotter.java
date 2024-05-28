package com.drex.pages;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Jotter {


        public static void main(String[] args) {
            String dateString = "August 20, 2015";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

            LocalDate localDate = LocalDate.parse(dateString, formatter);
            System.out.println(localDate.getMonth()); // Output: 2015-08-20
        }

}
