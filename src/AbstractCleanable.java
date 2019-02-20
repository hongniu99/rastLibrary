
public abstract class AbstractCleanable
{
    /**************************
     *   Data Members
     **************************/

    private int m_id;
    @SuppressWarnings( "unused" )
    private long m_pointer;
    private Cleaner m_cleaner;


    /**************************
     *   Constructors
     **************************/

    protected AbstractCleanable( )
    {
        // no args constructor for serialization of sub-types
        this( -1, -1, null );
    }

    protected AbstractCleanable( Cleaner cleaner )
    {
        this( -1, 0, cleaner );
    }

    protected AbstractCleanable( int id, long pointer, Cleaner cleaner )
    {
        m_id = id;
        m_pointer = pointer;
        m_cleaner = cleaner;
    }


    /**************************
     *   Methods
     **************************/

    public void cleanup( )
    {
        if( m_id >= 0 )
        {
            m_cleaner.cleanup( m_id );
            m_id = -1;
        }
    }


    /**************************
     *   Accessors
     **************************/

    protected int getId( )
    {
        return m_id;
    }
    protected void setId( int val )
    {
        m_id = val;
    }

    protected void setCleaner( Cleaner cleaner )
    {
        m_cleaner = cleaner;
    }
}
