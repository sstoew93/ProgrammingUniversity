package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(2d,2d);
        rect.calculateArea();
        System.out.println(rect.getArea());
    }
}
