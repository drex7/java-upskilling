package Week_2;

public class Question_4 {

    public static void divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        System.out.println(num1 / num2);
    }
    public static void main(String[] args) {

        try {
            divide(5, 0);
        } catch (ArithmeticException ae) {
            System.out.println("Divisor cannot be zero");
        }

    }
}
