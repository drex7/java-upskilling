package Week_2.Question_2;

//import java.awt.Color ;

import java.awt.*;

public class Question_2 {

    enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        BLACK
    };




        public static String getColorCode(Color color) {
//            Color color = Color.valueOf(colorString);
            String colorCode = "";
//            return "#"+ Integer.toHexString(Color.WHITE.getRGB()).substring(2);
            switch (color) {
                case RED:
                    colorCode = "#FF2D00";
                    break;
                case YELLOW:
                    colorCode = "#FFFF00";
                    break;
                case BLUE:
                    colorCode = "#0000FF";
                    break;
                case GREEN:
                    colorCode = "#008000";
                    break;
                case BLACK:
                    colorCode = "#000000";
                    break;
                default:
                    break;
            }
            return colorCode;
        }
    public static void main(String[] args) {


//        System.out.println(getColorCode("RED"));


    }
}
