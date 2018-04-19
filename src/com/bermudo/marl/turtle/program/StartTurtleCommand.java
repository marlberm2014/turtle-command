
package com.bermudo.marl.turtle.program;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The entry class for the turtle command program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class StartTurtleCommand
{

    private static final String DEBUG = "--debug";

    private static final String IGNORE_CASE = "--ignore_case";

    private static final String FILE = "--file";

    public static void main( String[] args )
    {
        boolean debug = false;
        boolean ignoreCase = false;
        System.out.println( "Starting turtle program..." );
        AbstractTurtleCommand turtleCommand = new CLITurtleCommand();
        for( int index = 0; index < args.length; index++ )
        {
            String string = args[index];
            if( DEBUG.equals( string ) )
            {
                System.out.println( "Debug mode activated..." );
                debug = true;
            }
            else if( IGNORE_CASE.equals( string ) )
            {
                System.out.println( "Command is now case insensitive..." );
            }
            else if( FILE.equals( string ) && index + 1 < args.length )
            {
                Path path = Paths.get( args[index + 1] );
                System.out.println( "Executing command from file: " + path.toAbsolutePath() );
                
            }
        }

        turtleCommand.debuggingFlags( debug, ignoreCase );
        turtleCommand.start();
    }

}
