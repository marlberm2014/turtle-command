/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * Test cases for {@link MoveCommand}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class MoveCommandTest
{

    private static final int MAXIMUM_DIMENSION = 5;

    private Turtle turtle;

    @Before
    public void setUp() throws Exception
    {
        turtle = spy( new Turtle( MAXIMUM_DIMENSION ) );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.MoveCommand#execute()}.
     */
    @Test
    public void testExecute()
    {
        turtle.setPlace( 0, 0, Turtle.Direction.NORTH );
        MoveCommand command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 1, turtle.getY() );
        assertEquals( "0,1,NORTH", turtle.toString() );
        
        turtle.setDirection( Turtle.Direction.SOUTH );
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 0, turtle.getY() );
        assertEquals( "0,0,SOUTH", turtle.toString() );
        
        turtle.setDirection( Turtle.Direction.EAST );
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 1, turtle.getX() );
        assertEquals( "1,0,EAST", turtle.toString() );
        
        turtle.setDirection( Turtle.Direction.WEST );
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 0, turtle.getX() );
        assertEquals( "0,0,WEST", turtle.toString() );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.MoveCommand#execute()}.
     */
    @Test
    public void testExecuteWhenTurtleIsNotPlaced()
    {
        MoveCommand command = new MoveCommand( turtle );
        command.execute();
        assertFalse( turtle.isPlaced() );
        verify( turtle, never() ).setCoordinates( anyInt(), anyInt() );
    }
    
    /**
     * Test method for {@link com.bermudo.marl.turtle.program.command.MoveCommand#execute()}.
     */
    @Test
    public void testExecuteWhenTurtleIsOutofBounds()
    {
        turtle.setPlace( 0, 4, Turtle.Direction.NORTH ); //setCoordinates once
        MoveCommand command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 4, turtle.getY() );
        assertEquals( "0,4,NORTH", turtle.toString() );
        verify( turtle, times(1) ).setCoordinates( anyInt(), anyInt() );
        
        turtle.setPlace( 0, 0, Turtle.Direction.SOUTH ); //setCoordinates twice
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 0, turtle.getY() );
        assertEquals( "0,0,SOUTH", turtle.toString() );
        verify( turtle, times(2) ).setCoordinates( anyInt(), anyInt() );
        
        turtle.setPlace( 4, 0, Turtle.Direction.EAST ); //setCoordinates thrice
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 4, turtle.getX() );
        assertEquals( "4,0,EAST", turtle.toString() );
        verify( turtle, times(3) ).setCoordinates( anyInt(), anyInt() );
        
        turtle.setPlace( 0, 0, Turtle.Direction.WEST ); //setCoordinates four times
        command = new MoveCommand( turtle );
        command.execute();
        assertEquals( 0, turtle.getX() );
        assertEquals( "0,0,WEST", turtle.toString() );
        verify( turtle, times(4) ).setCoordinates( anyInt(), anyInt() );
    }
}
