package com.patterns.command.commands;

/**
 * @author Elina Valieva on 16.03.2020
 */
public class PasteCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Paste command");
    }
}
