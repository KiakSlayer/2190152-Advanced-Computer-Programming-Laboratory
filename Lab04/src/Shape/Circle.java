package Shape;

public class Circle extends Shape {
    double radius;
    public Circle(double radius, String shapeColor) {
        super(shapeColor);
        this.radius = radius;
    }
    public double getArea() { return Math.PI*Math.pow(radius, 2); }

    public void printDetails() {
        System.out.println("Shape: Circle");
        System.out.println("Color: " + this.shapeColor);
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + this.getArea());
        System.out.println("----------------------");
    }
    
    public void resize(double factor) {
        this.radius = factor;
    }
}
