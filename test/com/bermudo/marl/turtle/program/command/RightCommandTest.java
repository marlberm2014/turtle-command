/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * Test cases for {@link RightCommand}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 *
 */
public class RightCommandTest extends CommandTest
{

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.RightCommand#execute()}.
     */
    @Test
    public void testExecute()
    {
        turtle.setPlace( 0, 0, Turtle.Direction.NORTH );
        Command command = new RightCommand( turtle );
        command.execute();
        assertEquals( Turtle.Direction.EAST, turtle.getDirection() );
        
        turtle.setPlace( 0, 0, Turtle.Direction.EAST );
        command = new RightCommand( turtle );
        command.execute();
        assertEquals( Turtle.Direction.SOUTH, turtle.getDirection() );
        
        turtle.setPlace( 0, 0, Turtle.Direction.SOUTH );
        command = new RightCommand( turtle );
        command.execute();
        assertEquals( Turtle.Direction.WEST, turtle.getDirection() );
        
        turtle.setPlace( 0, 0, Turtle.Direction.WEST );
        command = new RightCommand( turtle );
        command.execute();
        assertEquals( Turtle.Direction.NORTH, turtle.getDirection() );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.RightCommand#execute()}.
     */
    @Test
    public void testExecuteWhenTurtleIsNotPlaced()
    {
        Command command = new RightCommand( turtle );
        command.execute();
        verify( turtle, never() ).setDirection( Turtle.Direction.EAST );
        assertEquals( Turtle.Direction.NORTH, turtle.getDirection() );
    }
    
}
