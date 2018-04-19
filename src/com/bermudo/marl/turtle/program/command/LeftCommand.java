/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import com.bermudo.marl.turtle.program.data.Turtle;
import com.bermudo.marl.turtle.program.data.Turtle.Direction;

/**
 * The left use case of the turtle.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class LeftCommand implements Command
{

    private Turtle turtle;

    public LeftCommand( Turtle turtle )
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
                newDirection = Turtle.Direction.WEST;
            }
            else if( Turtle.Direction.WEST.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.SOUTH;
            }
            else if( Turtle.Direction.SOUTH.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.EAST;
            }
            else if( Turtle.Direction.EAST.equals( turtle.getDirection() ) )
            {
                newDirection = Turtle.Direction.NORTH;
            }
            
            turtle.setDirection( newDirection );
        }
    }

}
