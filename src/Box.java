import java.util.*;

public class Box {

    /**************************
     *   Data Members
     **************************/

    double x_min;
    double x_max;
    double y_min;
    double y_max;
    List<Vector2> fullPointList;



    /**************************
     *   Constructors
     **************************/
    public Box(double xmin, double xmax, double ymin, double ymax) {
        x_min = xmin;
        x_max = xmax;
        y_min = ymin;
        y_max = ymax;
        fullPointList = new ArrayList<Vector2>();
        //fix this double incrementation

        for (double i = x_min; i <= x_max; i++) {
            Vector2 newPoint = new Vector2(i, y_min);
            fullPointList.add(newPoint);
            newPoint = new Vector2(i, y_max);
            fullPointList.add(newPoint);
        }
        for (double i = y_min; i <= y_max; i++) {
            Vector2 newPoint = new Vector2(x_min, i);
            fullPointList.add(newPoint);
            newPoint = new Vector2(x_max, i);
            fullPointList.add(newPoint);
        }
    }
    public Box(Box other) {
        x_min = other.getXMin();
        x_max = other.getXMax();
        y_max = other.getYMax();
        y_min = other.getYMin();
        fullPointList = other.getFillList();
    }


    /**************************
     *   Methods
     **************************/
    public List<Vector2> getFillList() {
        return fullPointList;
    }
    public double getXMin() {
        return x_min;
    }
    public double getXMax( ) {
        return x_max;
    }
    public double getYMin() {
        return y_min;
    }

    public double getYMax() {
        return y_max;
    }


    //jeff things
    public double getWidth() {
        return x_max- x_min;
    }
    public double getHeight() {
        return y_max - y_min;
    }
    public boolean containsPoint (Vector2 point) {
        return containsPoint(point.get(0), point.get(1));
    }
    public boolean containsPoint(double x, double y) {
        return x>= x_min && x <= x_max && y >= y_min && y<= y_max;
    }

    public boolean intersects(Box other) {
        return other.containsPoint( getXMin(), getYMin() )
                || other.containsPoint( getXMin(), getYMax() )
                || other.containsPoint( getXMax(), getYMin() )
                || other.containsPoint( getXMax(), getYMax() );

    }








    //print
    public void printBoxPoints() {
        for (int i =0; i < fullPointList.size(); i++) {
            System.out.println("(" + fullPointList.get(i).get(0) + ", " + fullPointList.get(i).get(1) + ")");
        }
    }



    /**************************
     *   Methods
     **************************/







}
