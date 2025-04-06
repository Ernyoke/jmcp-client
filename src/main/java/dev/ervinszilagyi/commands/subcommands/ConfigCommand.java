package dev.ervinszilagyi.commands.subcommands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "config")
public class ConfigCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
