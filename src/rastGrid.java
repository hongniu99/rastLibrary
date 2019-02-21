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
    public void putPixel(Vector2 point) {
        int x = (int) point.get(0);
        int y = (int) point.get(1);
        grid[x][y] = 1;

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
                if (grid[i][j] == 0) {
                    System.out.print(". ");
                }
                else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }




    //main
    public static void main (String[] args) {



    }
}




