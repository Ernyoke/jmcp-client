package dev.ervinszilagyi.io;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.io.Console;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ConsoleProducer {
    private static final Logger logger = Logger.getLogger(ConsoleProducer.class);

    @Produces
    @ApplicationScoped
    public Cli createCli() {
        Console console = System.console();
        if (console == null) {
            logger.warn("No console available, using Scanner!");
            return new ScannerPrinterCli();
        }
        logger.info("Console available.");
        return new ConsoleCli(console);
    }
}
