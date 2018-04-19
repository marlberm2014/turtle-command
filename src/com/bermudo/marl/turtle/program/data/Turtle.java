package com.bermudo.marl.turtle.program.data;

/**
 * The turtle that consist of its coordinates and the direction it is facing.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class Turtle
{
    private static final int UNPLACED = -1;
    
    public static final int STEP_SIZE = 1;

    public enum Direction
    {
        NORTH, SOUTH, EAST, WEST
    }

    private int x;

    private int y;

    private Direction direction;

    private int bounds;

    public Turtle( int bounds )
    {
        if( bounds <= 0 )
        {
            throw new IllegalArgumentException( "Bounds should be greater than 0" );
        }
        this.bounds = bounds;
        this.x = UNPLACED;
        this.y = UNPLACED;
        this.direction = Direction.NORTH;
    }

    public void setPlace( int x, int y, Direction direction )
    {
        this.setCoordinates( x, y );
        this.direction = direction;
    }

    public void setCoordinates( int x, int y )
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Checks whether the turtle is inside the bounds.
     * 
     * @return true if the turtle is less than the bounds and greater than or equal to zero, false otherwise.
     */
    public boolean isPlaced()
    {
        return checkBounds( x, y );
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public boolean checkBounds( int paramX, int paramY )
    {
        return checkBounds( paramX ) && checkBounds( paramY );
    }

    private boolean checkBounds( int position )
    {
        return 0 <= position && position < bounds;
    }

    @Override
    public String toString()
    {
        return "" + getX() + "," + getY() + "," + getDirection();
    }
}
