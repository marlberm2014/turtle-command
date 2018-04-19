/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program.command;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * The report use case of the turtle.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 *
 */
public class ReportCommand implements Command
{

    private Turtle turtle;

    public ReportCommand( Turtle turtle )
    {
        this.turtle = turtle;
    }
    
    @Override
    public void execute()
    {
        if(turtle.isPlaced())
        {
            System.out.println( turtle );
        }
    }

}
