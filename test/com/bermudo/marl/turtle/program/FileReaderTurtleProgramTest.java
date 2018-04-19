/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.bermudo.marl.turtle.program.command.Command;
import com.bermudo.marl.turtle.program.data.Table;

/**
 * Test cases for {@link FileReaderTurtleProgram}
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class FileReaderTurtleProgramTest
{

    private static final String FILE_NAME = "test_turtle_command";

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

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
     * Test method for {@link com.bermudo.marl.turtle.program.FileReaderTurtleProgram#start()}.
     */
    @Test
    public void testStart() throws IOException
    {
        //Expected commands
        String place = "PLACE 1,2,EAST";
        String move = "MOVE";
        String left = "LEFT";
        String report = "REPORT";
        String stringToWrite = place + "\n" + move + "\n" + move + "\n" + left + "\n" + move + "\n" + report + "\n";

        File tempFile = testFolder.newFile( FILE_NAME );
        Path path = tempFile.toPath();
        Files.write( path, stringToWrite.getBytes() );
        AbstractTurtleProgram turtleCommand = new FileReaderTurtleProgram( table, path );

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

    /**
     * Test method for {@link com.bermudo.marl.turtle.program.FileReaderTurtleProgram#start()}.
     */
    @Test(expected = NoSuchFileException.class)
    public void testStartInvalidFile() throws IOException
    {
        File tempFile = testFolder.newFile( FILE_NAME );
        if( tempFile.delete() )
        {
            Path path = tempFile.toPath();
            new FileReaderTurtleProgram( table, path );
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
