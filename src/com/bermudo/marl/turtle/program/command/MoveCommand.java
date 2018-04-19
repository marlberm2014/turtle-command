/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * The move use case of the turtle.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class MoveCommand implements Command
{

    private Turtle turtle;

    public MoveCommand( Turtle turtle )
    {
        this.turtle = turtle;
    }

    @Override
    public void execute()
    {
        if( turtle.isPlaced() )
        {
            int x = turtle.getX();
            int y = turtle.getY();
            if( Turtle.Direction.NORTH.equals( turtle.getDirection() ) )
            {
                y += Turtle.STEP_SIZE;
            }
            else if( Turtle.Direction.SOUTH.equals( turtle.getDirection() ) )
            {
                y -= Turtle.STEP_SIZE;
            }
            else if( Turtle.Direction.EAST.equals( turtle.getDirection() ) )
            {
                x += Turtle.STEP_SIZE;
            }
            else if( Turtle.Direction.WEST.equals( turtle.getDirection() ) )
            {
                x -= Turtle.STEP_SIZE;
            }
            if( turtle.checkBounds( x, y ) )
            {
                turtle.setCoordinates( x, y );
            }
        }
    }

    @Override
    public String toString()
    {
        return "Move " + turtle.toString();
    }
}
