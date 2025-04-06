package dev.ervinszilagyi.io;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.text.TextContentRenderer;

import java.io.Console;

public class ConsoleCli implements Cli {
    private final Console console;

    public ConsoleCli(Console console) {
        this.console = console;
    }

    @Override
    public String readLine(String prompt) {
        return this.console.readLine(prompt);
    }

    @Override
    public void printLine(String line) {
        this.console.printf("%s\n", line);
    }
}
