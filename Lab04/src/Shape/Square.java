package Shape;

public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength, String shapeColor) {
        super(shapeColor);
        this.sideLength = sideLength;

    }

    public double getArea() {
        return this.sideLength * this.sideLength;
    }

    public void printDetails() {
        System.out.println("Shape: Square");
        System.out.println("Color: " + this.shapeColor);
        System.out.println("Side Length: " + this.sideLength);
        System.out.println("Area: " + this.getArea());
        System.out.println("----------------------");
    }

    public void resize(double factor) {
        this.sideLength = factor;
    }
}
