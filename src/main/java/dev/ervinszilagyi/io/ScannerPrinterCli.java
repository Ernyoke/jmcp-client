package dev.ervinszilagyi.io;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.text.TextContentRenderer;

import java.io.PrintStream;
import java.util.Scanner;

public class ScannerPrinterCli implements Cli {
    private final Scanner scanner;
    private final PrintStream printStream;

    public ScannerPrinterCli() {
        this.scanner = new Scanner(System.in);
        this.printStream = System.out;
    }

    public String readLine(String prompt) {
        this.printStream.print(prompt + " ");
        return this.scanner.nextLine();
    }

    public void printLine(String line) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(line);
        TextContentRenderer renderer = TextContentRenderer.builder().build();
        this.printStream.println(renderer.render(document));
    }
}
