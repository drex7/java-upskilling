package Week_2.Question_1;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getlength() {
        return length;
    }

    public void setlength(double length) {
        this.length = length;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = (length + width) * 2;
        System.out.printf("Rectangle with width %s and length %s has perimeter %s%n", this.width, this.length, perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = length * width;
        System.out.printf("Rectangle with width %s and length %s has area %s%n", this.width, this.length, area);
        return area;
    }
}
