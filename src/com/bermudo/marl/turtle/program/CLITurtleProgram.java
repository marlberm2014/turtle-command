/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program;

/**
 * Command line interface for the turtle program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 *
 */
public class CLITurtleProgram extends AbstractTurtleProgram
{

    @Override
    public String getNextCommand()
    {
        return System.console().readLine();
    }

}
