package Shape;

public abstract class Shape {
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
