package Week_2.Question_5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {
    private final double length;
    private final double breadth;

    public Area(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double returnArea() {
        return length * breadth;
    }


    public static void main(String[] args) {
        double length, breadth;

            System.out.print("Please enter the length of the rectangle: ");
            length = getUserInput();
            System.out.print("Please enter the breadth of the rectangle: ");
            breadth = getUserInput();

        Area rect = new Area(length, breadth);
        System.out.println("Area of the rectangle is: " + rect.returnArea());
    }

    public static double getUserInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine();
            return Double.parseDouble(input);
        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println("Input is not valid. Try again");
            return getUserInput();
        }
    }
}
