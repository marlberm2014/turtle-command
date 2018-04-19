/*
 *  Created 2018. Exercise for the mind
 *
 *  20 Apr 2018/bermudo                            
 */
package com.bermudo.marl.turtle.program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.bermudo.marl.turtle.program.data.Table;

/**
 * Command line interface for the turtle program.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public class FileReaderTurtleProgram extends AbstractTurtleProgram
{

    private List<String> commandList;

    public FileReaderTurtleProgram( Path filePath ) throws IOException
    {
        super();
        commandList = Files.readAllLines( filePath );
    }

    public FileReaderTurtleProgram( Table table, Path filePath ) throws IOException
    {
        super( table );
        commandList = Files.readAllLines( filePath );
    }

    @Override
    public String getNextCommand()
    {
        if(commandList.isEmpty())
        {
            return "";
        }
        return commandList.remove( 0 );
    }

}
