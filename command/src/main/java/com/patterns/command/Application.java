package com.patterns.command;

import com.patterns.command.commands.Command;
import com.patterns.command.commands.CopyCommand;
import com.patterns.command.commands.PasteCommand;
import com.patterns.command.commands.UndoCommand;

import java.util.LinkedList;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {
        Queue<Command> commands = getCommands();
        Executor executor = new Executor();
        executor.execute(commands);
    }

    private static Queue<Command> getCommands() {
        Queue<Command> commands = new LinkedList<>();
        commands.add(new CopyCommand());
        commands.add(new PasteCommand());
        commands.add(new UndoCommand());
        return commands;
    }
}
