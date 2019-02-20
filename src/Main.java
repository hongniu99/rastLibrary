import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        rastGrid start = new rastGrid(100);
        System.out.println("Grid size is " + start.getSize());


        Circle newCirc = new Circle(50,50, 20,0);
        List<Vector3> test = new ArrayList<Vector3>();
        test = newCirc.getFillList();

        /*Box newBox = new Box(2,4, 4,8);
        newBox.printBoxPoints();
        test = newBox.getFullPointList();*/


        //add to grid
        for (int i = 0; i < test.size(); i++) {
            Vector3 point = test.get(i);
            start.putPixel(point);
        }

        //print
        start.printGrid();




    }
}
