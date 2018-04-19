/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bermudo.marl.turtle.program.command.Command;
import com.bermudo.marl.turtle.program.data.Table;

/**
 * Test cases for {@link AbstractTurtleProgram}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class AbstractTurtleProgramTest
{

    private StubTable table;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        table = spy( new StubTable() );
    }

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.AbstractTurtleProgram#start()}.
     */
    @Test
    public void testStart()
    {
        //Expected commands
        String place = "PLACE 1,2,EAST";
        String move = "MOVE";
        String left = "LEFT";
        String report = "REPORT";
        
        List<String> commandList = new ArrayList<>();
        commandList.add( place );
        commandList.add( move );
        commandList.add( move );
        commandList.add( left );
        commandList.add( move );
        commandList.add( report );

        AbstractTurtleProgram turtleCommand = new StubTurtleCommand( commandList );
        turtleCommand.start();
        List<Command> actualCommand = table.getCommandList();

        String expectedTurtleLocation = "3,3,NORTH";

        assertEquals( place + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( move + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( move + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( left + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( move + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( report + " " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
    }

    private class StubTurtleCommand extends AbstractTurtleProgram
    {
        private List<String> commandList;

        public StubTurtleCommand( List<String> commandList )
        {
            super( table );
            this.commandList = commandList;
        }

        @Override
        public String getNextCommand()
        {
            if( commandList.isEmpty() )
            {
                return "";
            }
            return commandList.remove( 0 );
        }

    }

    private class StubTable extends Table
    {
        private List<Command> commandList;

        public StubTable()
        {
            super();
            this.commandList = new ArrayList<>();
        }

        @Override
        public void setCommand( Command command )
        {
            commandList.add( command );
            super.setCommand( command );
        }

        public List<Command> getCommandList()
        {
            return commandList;
        }
    }
}
