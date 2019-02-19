import java.util.ArrayList;
import java.util.List;

public class RastFillList {
    private List<Vector3> fillList;

    //constructor
    public RastFillList(double xcenter, double ycenter, double circRadius, double circOrientation) {
        setFillList(xcenter, ycenter, circRadius, circOrientation);
    }


    public List<Vector3> getFillList() {
        return fillList;
    }
    //setter method
    public List<Vector3> setFillList(double xcenter, double ycenter, double circRadius, double circOrientation) {
        //https://www.geeksforgeeks.org/mid-point-circle-drawing-algorithm/
        double x_center = xcenter;
        double y_center = ycenter;
        double radius = circRadius;
        double orientation = circOrientation;
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

    public void printFillList() {
        for (int i =0; i < fillList.size(); i++) {
            fillList.get(i).printVector();
        }
    }
}
