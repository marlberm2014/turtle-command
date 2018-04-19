package com.bermudo.marl.turtle.program.data;

import com.bermudo.marl.turtle.program.command.Command;

/**
 * The class where the turtle is free to roam.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class Table
{

    public static final int DEFAULT_DIMENSION = 5;

    private Command command;

    public void setCommand(Command command)
    {
        this.command = command;
    }
    
    public void doCommand()
    {
        if(command == null)
        {
            return;
        }
        command.execute();
    }
}
