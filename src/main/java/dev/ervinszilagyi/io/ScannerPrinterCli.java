package dev.ervinszilagyi.io;

import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import java.io.PrintStream;
import java.util.Scanner;

public class ScannerPrinterCli implements Cli {
    private final Scanner scanner;
    private final PrintStream printStream;

    static {
        FORMAT_OPTIONS.set(Parser.EXTENSIONS, Parser.EXTENSIONS.get(OPTIONS));
    }

    static final Parser PARSER = Parser.builder(OPTIONS).build();
    static final Formatter RENDERER = Formatter.builder(FORMAT_OPTIONS).build();

    public ScannerPrinterCli() {
        this.scanner = new Scanner(System.in);
        this.printStream = System.out;
    }

    public String readLine(String prompt) {
        this.printStream.print(prompt + " ");
        return this.scanner.nextLine();
    }

    public void printMdFormatted(String line) {
        Node document = PARSER.parse(line);
        String commonmark = RENDERER.render(document);
        printStream.println(commonmark);
    }
}
