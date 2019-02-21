public class Vertex {


    /**************************
     *   Data Members
     **************************/
     private double x_val;
     private double y_val;

    /**************************
     *   Constructors
     **************************/
    public Vertex() {
        x_val = 0;
        y_val = 0;
    }
    public Vertex(double x, double y) {
        x_val = x;
        y_val = y;
    }
    public Vertex(Vector2 point) {
        x_val = point.get(0);
        y_val = point.get(1);
    }



    /**************************
     *   Accessors
     **************************/
    public void setX_val(double x) {
        this.x_val = x;
    }
    public void setY_val(double y) {
        this.y_val = y;
    }
    public double getX_val() {
        return x_val;
    }
    public double getY_val() {
        return y_val;
    }
    public Vector2 getVertexVector() {
        return new Vector2(x_val, y_val);
    }
    /**************************
     *   Methods
     **************************/

}
