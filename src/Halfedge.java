public class Halfedge {

    /**************************
     *   Data Members
     **************************/
    private Vertex source;
    private Vertex target;


    /**************************
     *   Constructors
     **************************/
     public Halfedge() {
        source = new Vertex(0,0);
        target = new Vertex(0,0);
     }
     public Halfedge(Vertex start, Vertex end) {
        source = start;
        target = end;
     }

    /**************************
     *   Methods
     **************************/
     public Vertex getSource() {
        return source;
     }
     public Vertex getTarget() {
        return target;
     }


}
