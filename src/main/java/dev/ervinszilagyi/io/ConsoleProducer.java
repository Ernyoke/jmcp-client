package dev.ervinszilagyi.io;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.io.Console;
import java.util.logging.Logger;

@ApplicationScoped
public class ConsoleProducer {
    Logger logger = Logger.getLogger(ConsoleProducer.class.getName());

    @Produces
    @ApplicationScoped
    public Cli createCli() {
        Console console = System.console();
        if (console == null) {
            this.logger.warning("No console available");
            return new ScannerPrinterCli();
        }
        this.logger.fine("Console available");
        return new ConsoleCli(console);
    }
}
