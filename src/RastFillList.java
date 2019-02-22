import java.util.ArrayList;
import java.util.List;

public class RastFillList {
    private List<Vector3> fillList;

    //constructor
    public RastFillList(double xcenter, double ycenter, double circRadius, double circOrientation) {
        //setFillList(xcenter, ycenter, circRadius, circOrientation);
    }


    public List<Vector3> getFillList() {
        return fillList;
    }

    public void printFillList() {
        for (int i =0; i < fillList.size(); i++) {
            fillList.get(i).printVector();
        }
    }
}
