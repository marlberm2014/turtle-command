
package com.bermudo.marl.turtle.program;

/**
 * The entry class for the turtle command program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class StartTurtleCommand
{
    
    private static final String DEBUG = "--debug";

    public static void main( String[] args )
    {
        boolean debug = false;
        System.out.println( "Starting turtle program..." );
        for( String string : args )
        {
            if(DEBUG.equals( string ))
            {
                System.out.println( "Debug mode activated..." );
                debug = true;
            }
        }
        TurtleCommand turtleCommand = new TurtleCommand(debug);
        turtleCommand.start();
    }

}
