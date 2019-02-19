import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        rastGrid start = new rastGrid(100);
        System.out.println("Grid size is " + start.getSize());


        Circle newCirc = new Circle(50,50, 20,0);
        newCirc.printCircleInfo();
        newCirc.printCirclePoints();


        List<Vector3> test = new ArrayList<Vector3>();
        test = newCirc.getFillList();

        for (int i = 0; i < test.size(); i++) {
            Vector3 point = test.get(i);
            start.putPixel(point);
        }

        start.printGrid();



    }
}
