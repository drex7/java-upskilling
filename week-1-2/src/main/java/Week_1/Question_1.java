package Week_1;

public class Question_1 {
    public static void main(String[] args) {
        int bankBalance;
        bankBalance = 5000;

        bankBalance += 250;
        bankBalance -= 100;

        System.out.println("bankBalance = " + bankBalance);

        double fahrenheit = 75;
        double celsius = calculateCelsius(fahrenheit);
        System.out.println(75 + " fahrenheit equals " + celsius + " celsius");

    }
    private static double calculateCelsius(double fahrenheit) {
        return ((fahrenheit - 32) * 5) / 9;
    }
}
