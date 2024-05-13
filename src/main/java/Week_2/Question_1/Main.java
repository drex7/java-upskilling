package Week_2.Question_1;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 6);
        rectangle.calculatePerimeter();
        rectangle.calculateArea();

        Circle circle = new Circle(6);
        circle.calculateArea();
        circle.calculatePerimeter();
    }
}
