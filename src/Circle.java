import java.util.*;
import java.io.*;

public class Circle implements Serializable {


    /**************************
     *   Data Members
     **************************/

    private double centerX;
    private double centerY;
    private double radius;
    private Orientation orient;
    private List<Vector2> fillList;

    /**************************
     *   Definitions
     **************************/

    private static final long serialVersionUID = -8178661231591223781L;

    public static enum Side
    {
        BoundedSide,
        UnboundedSide,
        Boundary;
    }

    private static final Orientation DefaultOrientation = Orientation.Clockwise;

    /**************************
     *   Constructors
     **************************/

    //constructors
    public Circle(double x, double y, double rad, Orientation ori){
        centerX = x;
        centerY = y;
        radius = rad;
        orient = ori;
        setFillList();
    }


    public Circle(Vector2 center, double squaredRadius) {
        this(center, squaredRadius, DefaultOrientation);

    }
    public Circle(Vector2 center, double squaredRadius, Orientation ori) {

        centerX = center.get(0);
        centerY = center.get(1);
        radius = Math.sqrt(squaredRadius);
        orient = ori;

    }


    /**************************
     *   Methods
     **************************/



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
    public void setOrientation(Orientation ori) {
        orient = ori;
    }
    public Vector2 getCenter() {
        return new Vector2(centerX, centerY);
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
    public double getSquaredRadius() {
        return radius * radius;
    }
    public Orientation getOrientation() {
        return orient;
    }
    public List<Vector2> getFillList() {
        return fillList;
    }
    public Side getSide(Vector2 point) {
        double distSq = point.getSquaredDistance( getCenter() );
        double radiusSq = getSquaredRadius();

        if( radiusSq == distSq )
        {
            return Side.Boundary;
        }
        else if( distSq > radiusSq )
        {
            return Side.UnboundedSide;
        }
        else
        {
            return Side.BoundedSide;
        }
    }

    /*
    public native boolean isOnBoundedSide( Face face );
    public native boolean isOnUnboundedSide( Face face );
    public native boolean isOnBoundedSide( Vertex vertex );
    public native boolean isOnUnboundedSide( Vertex vertex );
    */
    public boolean equals( Circle other ) {
        boolean equality = true;
        if (this.getCenterX() != other.getCenterX()) {
            equality = false;
        }
        if (this.getCenterY() != other.getCenterY()) {
            equality = false;
        }
        if (this.getRadius() != other.getRadius()) {
            equality = false;
        }
        if (this.getOrientation() != other.getOrientation()) {
            equality = false;
        }

        return equality;
    }


    /*
    public edu.duke.donaldLab.share.geom.Circle toCircle( )
    {
        return new edu.duke.donaldLab.share.geom.Circle( getCenter(), Math.sqrt( getSquaredRadius() ) );
    }

    @Override
    public int hashCode( )
    {
        Vector2 point = getCenter();
        return HashCalculator.combineHashes(
                new Double( point.x ).hashCode(),
                new Double( point.y ).hashCode(),
                new Double( getSquaredRadius() ).hashCode()
        );
    }
    */
    @Override
    public boolean equals( Object other )
    {
        if( other == null )
        {
            return false;
        }
        else if( !( other instanceof Circle ) )
        {
            return false;
        }

        return equals( (Circle) other );
    }
    /**************************
     *   Functions
     **************************/

    public List<Vector2> setFillList() {
        //https://www.geeksforgeeks.org/mid-point-circle-drawing-algorithm/
        double x_center = centerX;
        double y_center = centerY;

        //initialize fill list
        fillList = new ArrayList<Vector2>();
        double x = radius;
        double y = 0;


        //first point

        Vector2 fill = new Vector2(x + x_center, y + y_center);
        fillList.add(fill);
        //0 radius returns only center
        if (radius == 0) {
            return fillList;
        }
        fill = new Vector2(-x + x_center, y + y_center);
        fillList.add(fill);
        fill = new Vector2(y + x_center, x + y_center);
        fillList.add(fill);
        fill = new Vector2(-y + x_center, -x + y_center);
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
            fill = new Vector2(x + x_center, y + y_center);
            fillList.add(fill);
            fill = new Vector2(-x + x_center, y + y_center);
            fillList.add(fill);
            fill = new Vector2(x + x_center, -y + y_center);
            fillList.add(fill);
            fill = new Vector2(-x + x_center, -y + y_center);
            fillList.add(fill);

            //if point is on x=y then perimeter is filled

            if (x != y) {
                fill = new Vector2(y + x_center, x + y_center);
                fillList.add(fill);
                fill = new Vector2(-y + x_center, x + y_center);
                fillList.add(fill);
                fill = new Vector2(y + x_center, -x + y_center);
                fillList.add(fill);
                fill = new Vector2(-y + x_center, -x + y_center);
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
            System.out.println("(" + fillList.get(i).get(0) + ", " + fillList.get(i).get(1) + ")");
        }
    }

}

