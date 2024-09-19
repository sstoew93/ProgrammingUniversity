package Polymorphism.Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * radius);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(Math.PI * (radius * radius));
        return super.getArea();
    }
}