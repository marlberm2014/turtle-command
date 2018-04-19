/*
 *  Created 2018. Exercise for the mind
 *
 *  19 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test cases for {@link Turtle}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class TurtleTest
{
    /**
     * Test method for {@link com.bermudo.marl.turtle.program.data.Turtle#isPlaced()}.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testConstructInvalidTurtle()
    {
        new Turtle( 0 );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.data.Turtle#isPlaced()}.
     */
    @Test
    public void testIsPlaced()
    {
        Turtle turtle = new Turtle( 3 );
        assertFalse( turtle.isPlaced() );
        turtle.setCoordinates( 4, 4 );
        assertFalse( turtle.isPlaced() );
        turtle.setCoordinates( 2, 1 );
        assertTrue( turtle.isPlaced() );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.data.Turtle#checkBounds(int, int)}.
     */
    @Test
    public void testCheckBounds()
    {
        Turtle turtle = new Turtle( 2 );
        assertFalse( turtle.checkBounds( -1, -1 ) );
        assertFalse( turtle.checkBounds( 1, -1 ) );
        assertFalse( turtle.checkBounds( -1, 1 ) );
        assertFalse( turtle.checkBounds( 2, 2 ) );
        assertFalse( turtle.checkBounds( 1, 2 ) );
        assertFalse( turtle.checkBounds( 2, 1 ) );
        assertTrue( turtle.checkBounds( 1, 1 ) );
    }

    /**
     * Test method for {@link Object#toString}.
     */
    @Test
    public void testToString()
    {
        Turtle turtle = new Turtle( 2 );
        assertEquals( "-1,-1,NORTH", turtle.toString() );
        turtle.setPlace( 0, 1, Turtle.Direction.EAST );
        assertEquals( "0,1,EAST", turtle.toString() );
    }
}
