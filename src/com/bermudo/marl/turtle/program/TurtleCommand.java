package com.bermudo.marl.turtle.program;

import com.bermudo.marl.turtle.program.command.Command;
import com.bermudo.marl.turtle.program.command.LeftCommand;
import com.bermudo.marl.turtle.program.command.MoveCommand;
import com.bermudo.marl.turtle.program.command.PlaceCommand;
import com.bermudo.marl.turtle.program.command.ReportCommand;
import com.bermudo.marl.turtle.program.command.RightCommand;
import com.bermudo.marl.turtle.program.data.Table;
import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * The class assembles the turtle command program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class TurtleCommand
{

    private Table table;

    private boolean debug;

    private boolean ignoreCase;

    public TurtleCommand()
    {
        this( new Table() );
    }

    public TurtleCommand( Table table )
    {
        this.table = table;
        this.debug = false;
        this.ignoreCase = false;
    }

    public void debuggingFlags( boolean paramDebug, boolean paramIgnoreCase )
    {
        this.debug = paramDebug;
        this.ignoreCase = paramIgnoreCase;
    }

    /**
     * Run the turtle program.
     */
    public void start()
    {
        Turtle turtle = new Turtle( Table.DEFAULT_DIMENSION );
        while( true )
        {
            String input = getNextCommand();

            Command command = parseStringCommand( turtle, input.split( " " ) );
            if( command == null )
            {
                System.err.println( "Invalid command, exiting program." );
                throw new RuntimeException( "Invalid command has been entered." );
            }
            table.setCommand( command );
            table.doCommand();
            if( debug )
            {
                System.out.println( turtle );
            }
        }
    }

    private Command parseStringCommand( Turtle turtle, String[] splitInput )
    {
        Command command = null;
        String commandStr = splitInput[0];
        if( ignoreCase )
        {
            commandStr = commandStr.toUpperCase();
        }
        if( Command.Type.PLACE.toString().equals( commandStr ) )
        {
            return new PlaceCommand( turtle, splitInput[1] );
        }
        else if( Command.Type.MOVE.toString().equals( commandStr ) )
        {
            return new MoveCommand( turtle );
        }
        else if( Command.Type.LEFT.toString().equals( commandStr ) )
        {
            return new LeftCommand( turtle );
        }
        else if( Command.Type.RIGHT.toString().equals( commandStr ) )
        {
            return new RightCommand( turtle );
        }
        else if( Command.Type.REPORT.toString().equals( commandStr ) )
        {
            return new ReportCommand( turtle );
        }
        return command;
    }

    private String getNextCommand()
    {
        return System.console().readLine();
    }
}