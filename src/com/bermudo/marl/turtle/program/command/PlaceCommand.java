package com.bermudo.marl.turtle.program.command;

import com.bermudo.marl.turtle.program.data.Turtle;

/**
 * The place use case of the turtle.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class PlaceCommand implements Command
{

    private Turtle turtle;

    private String argument;

    public PlaceCommand( Turtle turtle, String argument )
    {
        this.turtle = turtle;
        this.argument = argument;
    }

    /**
     * Place the turtle in the given argument coordinates and facing the given direction. Ignores the command if the
     * argument is out of bounds.
     * 
     * @see com.bermudo.marl.turtle.program.command.Command#execute()
     * @throws IllegalArgumentException when the comma separate argument is not equal to 3 strings or if the given
     *         direction is not valid.
     * @throws NumberFormatException when the given coordinates are not numeric.
     */
    @Override
    public void execute()
    {
        String[] arguments = argument.split( "," );
        if( arguments.length != 3 )
        {
            throw new IllegalArgumentException(
                "Expecting X,Y,F for PLACE command where X and Y is the coordinate and F is where the turtle will be facing." );
        }
        int x = Integer.parseInt( arguments[0] );
        int y = Integer.parseInt( arguments[1] );
        if( turtle.checkBounds( x, y ) )
        {
            Turtle.Direction direction = Turtle.Direction.valueOf( arguments[2] );
            turtle.setPlace( x, y, direction );
        }
    }
    
    @Override
    public String toString()
    {
        return "Place " + argument + " " + turtle.toString();
    }
}
