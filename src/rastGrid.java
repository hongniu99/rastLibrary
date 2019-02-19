import java.util.*;

public class rastGrid {
    //variables
    private int meshSize;
    private int[][] grid;

    //constructor
    public rastGrid(int gridSize) {
        meshSize = gridSize;
        grid = new int[gridSize][gridSize];
    }

    //accessors
    public int getSize() {
        return meshSize;
    }
    public int[][] getGridList() {
        return grid;
    }
    //filling methods
    public void putPixel(int x, int y) {
        grid[x][y] = (1);
    }
    public void removePixel(int x, int y) {
        grid[x][y] = (0);
    }
    public int checkPixel(int x, int y) {
        return grid[x][y];
    }
    //print
    public void printGrid() {
        for (int i = 0; i < meshSize; i++) {
            for (int j = 0; j < meshSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main (String[] args) {

        rastGrid start = new rastGrid(10);
        System.out.println(start.getSize());
        start.putPixel(3,4);
        System.out.println("Pixel is " + start.checkPixel(3,4));
        System.out.println("hi");
        start.printGrid();

    }
}




