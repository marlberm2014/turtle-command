/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import com.bermudo.marl.turtle.program.data.Turtle;
import com.bermudo.marl.turtle.program.data.Turtle.Direction;

/**
 * The right use case of the turtle.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class RightCommand implements Command
{

    private Turtle turtle;

    public RightCommand( Turtle turtle )
    {
        this.turtle = turtle;
    }

    @Override
    public void execute()
    {
        if( turtle.isPlaced() )
        {
            Direction newDirection = turtle.getDirection();
            if( Turtle.Direction.NORTH.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.EAST;
            }
            else if( Turtle.Direction.EAST.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.SOUTH;
            }
            else if( Turtle.Direction.SOUTH.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.WEST;
            }
            else if( Turtle.Direction.WEST.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.NORTH;
            }
            
            turtle.setDirection( newDirection );
        }
    }

    @Override
    public String toString()
    {
        return "RIGHT " + turtle.toString();
    }
}
