package Week_1;

public class Question_3 {

    public static void main(String[] args) {
        int age = 85;

        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        switch (age) {
            case (12):
                System.out.println("You are a child.");
                break;
            case 19:
                System.out.println("You are a teenager.");
                break;
            case 59:
                System.out.println("You are an adult.");
                break;
            case 60:
                System.out.println("You are an senior citizen.");
                break;
            default:
                System.out.println("Invalid age.");
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        enum DAYS { MON, TUE, WED, THUR, FRI, SAT, SUN };
        enum MEALS { BREAKFAST, LUNCH, DINNER };

        for (DAYS day : DAYS.values()) {
            System.out.println("Day: " + day);
            for (MEALS meal : MEALS.values()) {
                System.out.println("\t" + meal);
            }
        }

        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
