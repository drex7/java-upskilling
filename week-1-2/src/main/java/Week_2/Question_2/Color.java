package Week_2.Question_2;

public enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        BLACK;

    public static String getColorCode(String colorInput) {

        Color colorEnum = null;
        try {
            colorEnum = Color.valueOf(colorInput);
        } catch (IllegalArgumentException e) {

            return "";
        }
        //            return "#"+ Integer.toHexString(Color.WHITE.getRGB()).substring(2);
        return switch (colorEnum) {
            case RED -> "#FF2D00";
            case YELLOW -> "#FFFF00";
            case BLUE -> "#0000FF";
            case GREEN -> "#008000";
            case BLACK -> "#000000";
//            default -> "Color Code Not Defined Yet";
        };
    }

    public static void printColor(String color) {
        String colorCode = getColorCode(color);
        if (colorCode.isEmpty()) {
            System.out.printf("No color code defined color: %s yet. Try another%n", color);
            return;
        }
        System.out.printf("%s has color code %s%n", color, colorCode);
    }
}
