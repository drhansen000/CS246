package circleCalculator;

import java.util.Scanner;

public class CircleCalculator {
    private float radius;
    private double circumference;
    private double area;

    void getRadius() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the radius: ");

        try {
            this.radius = scanner.nextFloat();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    void displayCircumference() {
        this.circumference = (2 * Math.PI * this.radius);
        System.out.print("The circumference is ");
        System.out.format("%.2f%n", this.circumference);
    }

    void displayArea() {
        this.area = (Math.PI * (this.radius * this.radius));
        System.out.print("The area is ");
        System.out.format("%.2f%n", this.area);
    }

    public static void main(String[] args) {
        CircleCalculator circle = new CircleCalculator();
        circle.getRadius();
        circle.displayCircumference();
        circle.displayArea();
    }
}
