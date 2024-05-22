package Week_2;


abstract class Vehicle {
    String model;
    String make;
    String year;

    public Vehicle(String make, String model, String year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }

    abstract void accelerate();
}

class Car extends Vehicle {
    public Car(String make, String model, String year) {
        super(make, model, year);
    }

    void accelerate() {
        System.out.printf("%s : %s %s Vroooom %n", this.make, this.model, this.year);
    }
}

class Bike extends Vehicle {
    public Bike(String make, String model, String year) {
        super(make, model, year);
    }

    void accelerate() {
        System.out.printf("%s : %s %s Chichichichi %n", this.make, this.model, this.year);
    }

}

public class Question_3 {
    public static void main(String[] args) {
        Car bmw = new Car("Mercendes", "C5", "2025");
        bmw.accelerate();

        Bike bmx = new Bike("BMX", "Abochi", "1957");
        bmx.accelerate();
    }
}
