

import java.io.Serializable;

public class Vector2 implements Serializable
{
    /**************************
     *   Definitions
     **************************/

    private static final long serialVersionUID = 4346075783891245919L;

    public static final int Dimension = 2;

    private static final Vector2 Origin = new Vector2( 0.0, 0.0 );
    private static final Vector2 UnitX = new Vector2( 1.0, 0.0 );
    private static final Vector2 UnitY = new Vector2( 0.0, 1.0 );


    /**************************
     *   Fields
     **************************/

    public double x;
    public double y;


    /**************************
     *   Constructors
     **************************/

    public Vector2( )
    {
        x = 0.0;
        y = 0.0;
    }

    public Vector2( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    public Vector2( double[] vals )
    {
        set( vals );
    }

    public Vector2( Vector2 other )
    {
        set( other );
    }


    /**************************
     *   Accessors
     **************************/

    public double get( int i )
    {
        switch( i )
        {
            case 0: return x;
            case 1: return y;
        }

        assert( false ) : "Invalid index: " + i;

        // just to make the compiler happy
        return Double.NaN;
    }

    public void set( int i, double val )
    {
        switch( i )
        {
            case 0: x = val; return;
            case 1: y = val; return;
        }

        assert( false ) :  "Invalid index: " + i;
    }

    public void set( Vector2 other )
    {
        x = other.x;
        y = other.y;
    }

    public void set( double a, double b )
    {
        x = a;
        y = b;
    }

    public void set( double[] vals )
    {
        assert( vals.length == Vector2.Dimension );

        x = vals[0];
        y = vals[1];
    }


    /**************************
     *   Static Methods
     **************************/

    public static void getUnitX( Vector2 v )
    {
        v.set( UnitX );
    }

    public static void getUnitY( Vector2 v )
    {
        v.set( UnitY );
    }

    public static void getOrigin( Vector2 v )
    {
        v.set( Origin );
    }

    public static Vector2 getUnitX( )
    {
        return new Vector2( UnitX );
    }

    public static Vector2 getUnitY( )
    {
        return new Vector2( UnitY );
    }

    public static Vector2 getOrigin( )
    {
        return new Vector2( Origin );
    }


    /**************************
     *   Methods
     **************************/

    public double getSquaredLength( ) {
        return x*x + y*y;
    }

    public double getLength( ) {
        return Math.sqrt( getSquaredLength() );
    }

    public void normalize( )
    {
        double length = getLength();
        x /= length;
        y /= length;
    }

    public double getSquaredDistance( Vector2 other )
    {
        double dx = other.x - x;
        double dy = other.y - y;
        return dx*dx + dy*dy;
    }

    public double getDistance( Vector2 other )
    {
        return Math.sqrt( getSquaredDistance( other ) );
    }

    public void add( Vector2 other )
    {
        x += other.x;
        y += other.y;
    }

    public void subtract( Vector2 other )
    {
        x -= other.x;
        y -= other.y;
    }

    public void scale( double s )
    {
        x *= s;
        y *= s;
    }

    public void negate( )
    {
        x = -x;
        y = -y;
    }

    public double getDot( Vector2 other )
    {
        return x * other.x + y * other.y;
    }


    @Override
    public String toString( )
    {
        return "( " + x + ", " + y + " )";
    }

}
