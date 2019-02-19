import java.util.*;

public class Circle {
    private double centerX;
    private double centerY;
    private double radius;
    private double orientation;

    //constructors
    public Circle(double x, double y, double rad, double ori){
        centerX = x;
        centerY = y;
        radius = rad;
        orientation = ori;
    }
    //vector center constructor
    public Circle(Vector3 center, double rad, double ori) {
        centerX = center.getX();
        centerY = center.getY();
        radius = rad;
        orientation = ori;
    }

    //accessors
    public void setCenterX(double x) {
        centerX = x;
    }
    public void setCenterY(double y) {
        centerX = y;
    }
    public void setRadius(double rad) {
        radius = rad;
    }
    public void setOrientation(double ori) {
        orientation = ori;
    }
    public Vector3 getCenter() {
        return new Vector3(centerX, centerY);
    }
    public double getCenterX() {
        return centerX;
    }
    public double getCenterY() {
        return centerY;
    }
    public double getRadius() {
        return radius;
    }
    public double getOrientation() {
        return orientation;
    }
    //print circle
    public void printCircle() {
        System.out.println("Center: (" + this.getCenterX() + ", " + this.getCenterY() + "), Radius: " + this.getRadius() + ", Orientation: " + this.getOrientation());
    }


}

