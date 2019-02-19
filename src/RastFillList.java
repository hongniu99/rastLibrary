import java.util.ArrayList;
import java.util.List;

public class RastFillList {
    private List<Vector3> fillList;

    //constructor
    public RastFillList(Circle newCircle) {
        setFillList(newCircle);
    }

    public List<Vector3> setFillList(Circle newCircle) {
        double centerX = newCircle.getCenterX();
        double centerY = newCircle.getCenterY();
        double radius = newCircle.getRadius();
        double orientation = newCircle.getOrientation();

        fillList = new ArrayList<Vector3>();






















        return fillList;
    }


}
