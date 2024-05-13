package Week_2.Question_1;

public class Circle extends Shape {
    private double radius;
    private final double PI = Math.PI;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = PI * Math.pow(radius, 2);
        System.out.printf("Circle with radius %s has area %s%n", this.radius, area);
        return area;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * PI * radius;
        System.out.printf("Circle with radius %s has perimeter %s%n", this.radius, perimeter);
        return perimeter;
    }

    //    2πr
//    A = \pi r^2
//     P = (L + W) × 2
//    LxW

}
