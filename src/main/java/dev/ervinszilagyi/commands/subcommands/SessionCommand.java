package dev.ervinszilagyi.commands.subcommands;

import dev.ervinszilagyi.Bot;
import dev.ervinszilagyi.io.Cli;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.time.LocalDate;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "session")
public class SessionCommand implements Callable<Integer> {
    private final Cli cli;
    private final Bot bot;

    @Inject
    public SessionCommand(Cli cli, Bot bot) {
        this.cli = cli;
        this.bot = bot;
    }
    
    @Override
    public Integer call() throws Exception {
        while (true) {
            String input = cli.readLine(">>");

            if (input.equalsIgnoreCase("/exit")) {
                break;
            }

            LocalDate now = LocalDate.now();

            String answer = this.bot.chat(input, now.toString());
            this.cli.printMdFormatted(answer);
        }

        return 0;
    }
}
