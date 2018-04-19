package com.bermudo.marl.turtle.program.command;

/**
 * Interface for the command pattern.
 *
 * @author <a HREF="mailto:marl.aldwin.bermudo@gmail.com">Bermudo, Marl</a>
 */
public interface Command
{
    public enum Type
    {
        PLACE
    }

    /**
     * Executes the command.
     */
    public void execute();
}
