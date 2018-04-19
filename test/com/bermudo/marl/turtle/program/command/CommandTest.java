/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import static org.mockito.Mockito.spy;

import org.junit.Before;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * The super class for unit testing implementors of {@link Command}.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class CommandTest
{

    protected static final int MAXIMUM_DIMENSION = 5;

    protected Turtle turtle;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        turtle = spy( new Turtle( MAXIMUM_DIMENSION ) );
    }
}
