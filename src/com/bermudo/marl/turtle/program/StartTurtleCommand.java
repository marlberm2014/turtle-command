
package com.bermudo.marl.turtle.program;

/**
 * The entry class for the turtle command program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class StartTurtleCommand
{
    
    private static final String DEBUG = "--debug";
    private static final String IGNORE_CASE = "--ignore_case";

    public static void main( String[] args )
    {
        boolean debug = false;
        boolean ignoreCase = false;
        System.out.println( "Starting turtle program..." );
        for( String string : args )
        {
            if(DEBUG.equals( string ))
            {
                System.out.println( "Debug mode activated..." );
                debug = true;
            }
            else if(IGNORE_CASE.equals( string ))
            {
                System.out.println( "Command is now case insensitive..." );
            }
        }
        TurtleCommand turtleCommand = new TurtleCommand();
        turtleCommand.debuggingFlags( debug, ignoreCase );
        turtleCommand.start();
    }

}
