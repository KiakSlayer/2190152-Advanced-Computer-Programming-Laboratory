package Shape;

public class Rectangle extends Shape {
    double width;
    double height;
    public Rectangle(double width, double height, String shapeColor) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return (width * height);
    }
    public void printDetails() {
        System.out.println("Shape: Rectangle");
        System.out.println("Color: " + this.shapeColor);
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("Area: " + this.getArea());
        System.out.println("----------------------");
    }
    
    public void resize(double factor) {
        this.width = factor;
        this.height = factor;
    }
}
