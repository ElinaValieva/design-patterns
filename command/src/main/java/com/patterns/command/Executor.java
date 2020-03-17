package com.patterns.command;

import com.patterns.command.commands.Command;

import java.util.Queue;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class Executor {

    public void execute(Queue<Command> commands) {
        for (Command command : commands) {
            command.execute();
        }
    }
}
