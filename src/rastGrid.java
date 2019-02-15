import javax.sound.midi.SysexMessage;
import java.util.*;

public class rastGrid {
    private int meshSize;
    private List[][] grid;

    public rastGrid(int gridSize) {
        meshSize = gridSize;
        grid = new ArrayList[gridSize][gridSize];
    }

    public int getSize() {
        return meshSize;
    }
    public List[][] getGridList() {
        return grid;
    }
    public void colorIn(int x, int y) {
        grid[x][y].add(1);
    }
    public static void main (String[] args) {
        rastGrid start = new rastGrid(5);

        System.out.println(start.getSize());
        System.out.println()
        System.out.println("hi");
    }
}




