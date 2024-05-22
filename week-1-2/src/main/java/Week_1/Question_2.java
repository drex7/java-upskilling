package Week_1;

public class Question_2 {

    private static void printNameDetails(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        System.out.printf("Hello, my name is %s. %n", fullName);
        System.out.printf("There are %d letters in my first name and %d letters in my last name.", firstName.length(), lastName.length());
    }

    public static void main(String[] args) {
        printNameDetails("Derrick", "Asamoah");
    }
}
