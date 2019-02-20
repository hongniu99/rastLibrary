import java.util.*;

public class Box extends AbstractCleanable {
    double x_min;
    double x_max;
    double y_min;
    double y_max;
    List<Vector3> fullPointList;




    /**************************
     *   Definitions
     **************************//*

    private static final long serialVersionUID = -6742712402374735723L;


    *//**************************
     *   Data Members
     **************************//*

    private static Cleaner m_cleaner;


    *//**************************
     *   Constructors
     **************************//*

    static
    {
        m_cleaner = new Cleaner( )
        {
            @Override
            public void cleanup( int id )
            {
                Box.cleanup( id );
            }
        };
    }
    */
    public Box(double xmin, double xmax, double ymin, double ymax) {
        x_min = xmin;
        x_max = xmax;
        y_min = ymin;
        y_max = ymax;
        fullPointList = new ArrayList<Vector3>();
        //fix this double incrementation

        //DJSFJS DKLFJL KSDJFKJSDKLJF not working
        for (double i = x_min; i <= x_max; i++) {
            Vector3 newPoint = new Vector3(i, y_min);
            fullPointList.add(newPoint);
            newPoint = new Vector3(i, y_max);
            fullPointList.add(newPoint);
        }
        for (double i = y_min; i <= y_max; i++) {
            Vector3 newPoint = new Vector3(i, x_min);
            fullPointList.add(newPoint);
            newPoint = new Vector3(i, x_max);
            fullPointList.add(newPoint);
        }
    }
    public Box(Box other) {
        x_min = other.getXMin();
        x_max = other.getXMax();
        y_max = other.getYMax();
        y_min = other.getYMin();
        fullPointList = other.getFullPointList();
    }


    /**************************
     *   Methods
     **************************/
    public List<Vector3> getFullPointList() {
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

    public double getWidth() {
        return x_max- x_min;
    }
    public double getHeight() {
        return y_max - y_min;
    }
    public boolean containsPoint (Vector3 point) {
        return containsPoint(point.getX(), point.getY());
    }
    public boolean containsPoint(double x, double y) {
        return x>= x_min && x <= x_max && y >= y_min && y<= y_max;
    }
    //print
    public void printBoxPoints() {
        for (int i =0; i < fullPointList.size(); i++) {
            fullPointList.get(i).printVector();
        }
    }










}
