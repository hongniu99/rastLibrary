public class Vector3 {
    private double vectorX;
    private double vectorY;


    //constructor
    public Vector3(double x, double y) {
        vectorX = x;
        vectorY = y;
    }

    //accessors
    public void setX(double x) {
        vectorX = x;
    }
    public void setY(double y) {
        vectorX = y;
    }
    public double getX() {
        return vectorX;
    }
    public double getY() {
        return vectorY;
    }
    //print
    public void printVector() {
        System.out.println("(" + this.getX() + ", " + this.getY() + ")");
    }

}
