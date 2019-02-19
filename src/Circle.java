import java.util.*;

public class Circle {
    private double centerX;
    private double centerY;
    private double radius;
    private double orientation;
    private List<Vector3> fillList;

    //constructors
    public Circle(double x, double y, double rad, double ori){
        centerX = x;
        centerY = y;
        radius = rad;
        orientation = ori;
        setFillList();
    }
    //vector center constructor
    public Circle(Vector3 center, double rad, double ori) {
        centerX = center.getX();
        centerY = center.getY();
        radius = rad;
        orientation = ori;
        setFillList();
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
    public List<Vector3> getFillList() {
        return fillList;
    }


    public List<Vector3> setFillList() {
        //https://www.geeksforgeeks.org/mid-point-circle-drawing-algorithm/
        double x_center = centerX;
        double y_center = centerY;

        //initialize fill list
        fillList = new ArrayList<Vector3>();
        double x = radius;
        double y = 0;


        //first point

        Vector3 fill = new Vector3(x + x_center, y + y_center);
        fillList.add(fill);
        //0 radius returns only center
        if (radius == 0) {
            return fillList;
        }
        fill = new Vector3(-x + x_center, y + y_center);
        fillList.add(fill);
        fill = new Vector3(y + x_center, x + y_center);
        fillList.add(fill);
        fill = new Vector3(-y + x_center, -x + y_center);
        fillList.add(fill);

        //initialize midpoint P
        double P = 1 - radius;
        while (x > y) {
            y++;

            // Mid-point is inside or on the perimeter
            if (P <= 0)
                P = P + 2 * y + 1;

                // Mid-point is outside the perimeter
            else {
                x--;
                P = P + 2 * y - 2 * x + 1;
            }

            // All the perimeter points have already been added
            if (x < y) {
                break;
            }

            //add reflection in other octants
            fill = new Vector3(x + x_center, y + y_center);
            fillList.add(fill);
            fill = new Vector3(-x + x_center, y + y_center);
            fillList.add(fill);
            fill = new Vector3(x + x_center, -y + y_center);
            fillList.add(fill);
            fill = new Vector3(-x + x_center, -y + y_center);
            fillList.add(fill);

            //if point is on x=y then perimeter is filled

            if (x != y) {
                fill = new Vector3(y + x_center, x + y_center);
                fillList.add(fill);
                fill = new Vector3(-y + x_center, x + y_center);
                fillList.add(fill);
                fill = new Vector3(y + x_center, -x + y_center);
                fillList.add(fill);
                fill = new Vector3(-y + x_center, -x + y_center);
                fillList.add(fill);
            }

        }
        return fillList;
    }


    //print circle
    public void printCircleInfo() {
        System.out.println("Center: (" + this.getCenterX() + ", " + this.getCenterY() + "), Radius: " + this.getRadius() + ", Orientation: " + this.getOrientation());
    }
    //print list of points
    public void printCirclePoints() {
        for (int i =0; i < fillList.size(); i++) {
            fillList.get(i).printVector();
        }
    }

}

