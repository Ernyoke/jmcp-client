package dev.ervinszilagyi;

import dev.ervinszilagyi.commands.subcommands.ConfigCommand;
import dev.ervinszilagyi.commands.subcommands.SessionCommand;
import picocli.CommandLine;

@io.quarkus.picocli.runtime.annotations.TopCommand
@CommandLine.Command(name = "jmcp", mixinStandardHelpOptions = true, subcommands = {
        SessionCommand.class,
        ConfigCommand.class
})
public class TopCommand implements Runnable {
    @Override
    public void run() {
    }
}
