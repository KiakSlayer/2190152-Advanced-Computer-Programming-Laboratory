abstract class Shape {
    protected String shapeColor;
    public double factor;
    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }
    public String getColor() {
        return this.shapeColor;
    }
    public abstract double getArea();
    public abstract void printDetails();
    public abstract void resize(double factor);

}

class Square extends Shape {
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

class Rectangle extends Shape {
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

class Circle extends Shape {
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

public class Lab4_6538092821 {
    public static void main(String[] args) throws Exception {
        Shape[] shapeArray = new Shape[5];
        shapeArray[0] = new Square(5.0, "Red");
        shapeArray[1] = new Square(3.0, "Blue");
        shapeArray[2] = new Rectangle(4.0, 6.0, "Green");
        shapeArray[3] = new Rectangle(2.0, 8.0, "Yellow");
        shapeArray[4] = new Circle(7.0, "Orange");

        for(Shape shape : shapeArray){
            shape.printDetails();
        }
        for(Shape shape : shapeArray){
            shape.resize(2);
            shape.printDetails();
        }
    }
}
