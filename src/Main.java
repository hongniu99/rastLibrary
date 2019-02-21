import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        rastGrid start = new rastGrid(50);
        System.out.println("Grid size is " + start.getSize());


        Circle newCirc = new Circle(50,50, 20, Orientation.Clockwise);
        List<Vector2> test = new ArrayList<Vector2>();
        test = newCirc.getFillList();

        Box newBox = new Box(2,4, 4,8);
        test = newBox.getFillList();
        Box newBox2 = new Box(3,5,2,9);
        test = newBox2.getFillList();

        //add to grid
        for (int i = 0; i < test.size(); i++) {
            Vector2 point = test.get(i);
            start.putPixel(point);
        }

        //print
        start.printGrid();
        System.out.println(newBox.intersects(newBox2));
        System.out.println(newBox2.containsPoint(3,4));
        System.out.println(newCirc.getOrientation());

    }
}
