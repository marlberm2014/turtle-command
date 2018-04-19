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
 * Test cases for {@link AbstractTurtleCommand}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class AbstractTurtleCommandTest
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
     * Test method for {@link com.bermudo.marl.turtle.program.AbstractTurtleCommand#start()}.
     */
    @Test
    public void testStart()
    {
        List<String> commandList = new ArrayList<>();
        commandList.add( "PLACE 1,2,EAST" );
        commandList.add( "MOVE");
        commandList.add( "MOVE");
        commandList.add( "LEFT");
        commandList.add( "MOVE");
        commandList.add( "REPORT");
        
        AbstractTurtleCommand turtleCommand = new StubTurtleCommand( commandList );
        turtleCommand.start();
        List<Command> actualCommand = table.getCommandList();
        
        String expectedTurtleLocation = "3,3,NORTH";
        
        assertEquals( "Place 1,2,EAST " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( "Move " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( "Move " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( "Left " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( "Move " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
        assertEquals( "Report " + expectedTurtleLocation, actualCommand.remove( 0 ).toString() );
    }
    
    private class StubTurtleCommand extends AbstractTurtleCommand
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
            if( commandList.size() == 0 )
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
