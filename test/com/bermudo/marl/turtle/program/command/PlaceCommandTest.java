/*
 *  Created 2018. Exercise for the mind
 *
 *  19 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * Test cases for {@link PlaceCommand}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class PlaceCommandTest extends CommandTest
{

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.PlaceCommand#execute()}.
     */
    @Test
    public void testExecute()
    {
        String expected = "3,3,EAST";
        Command command = new PlaceCommand( turtle, expected );
        command.execute();
        verify( turtle ).setPlace( 3, 3, Turtle.Direction.EAST );
        assertEquals( expected, turtle.toString() );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.PlaceCommand#execute()}.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testExecuteIncompleteArgument()
    {
        Command command = new PlaceCommand( turtle, "1" );
        command.execute();
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.PlaceCommand#execute()}.
     */
    @Test( expected = NumberFormatException.class )
    public void testExecuteInvalidCoordinates()
    {
        Command command = new PlaceCommand( turtle, "a,b,c" );
        command.execute();
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.PlaceCommand#execute()}.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testExecuteInvalidDirection()
    {
        Command command = new PlaceCommand( turtle, "1,1,c" );
        command.execute();
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.PlaceCommand#execute()}.
     */
    @Test
    public void testExecuteCoordinatesOutofBounds()
    {
        Command command = new PlaceCommand( turtle, "-1,-1,NORTH" );
        command.execute();
        verify( turtle, never() ).setPlace( anyInt(), anyInt(), any( Turtle.Direction.class ) );
        command = new PlaceCommand( turtle, "6,6,NORTH" );
        verify( turtle, never() ).setPlace( anyInt(), anyInt(), any( Turtle.Direction.class ) );
    }

}
