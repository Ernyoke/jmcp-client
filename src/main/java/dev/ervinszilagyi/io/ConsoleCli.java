package dev.ervinszilagyi.io;

import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import java.io.Console;

public class ConsoleCli implements Cli {
    static {
        FORMAT_OPTIONS.set(Parser.EXTENSIONS, Parser.EXTENSIONS.get(OPTIONS));
    }

    static final Parser PARSER = Parser.builder(OPTIONS).build();
    static final Formatter RENDERER = Formatter.builder(FORMAT_OPTIONS).build();

    private final Console console;

    public ConsoleCli(Console console) {
        this.console = console;
    }

    @Override
    public String readLine(String prompt) {
        return this.console.readLine(prompt);
    }

    @Override
    public void printMdFormatted(String line) {
        Node document = PARSER.parse(line);
        String commonmark = RENDERER.render(document);
        this.console.printf("%s\n", commonmark);
    }
}
