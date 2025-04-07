package dev.ervinszilagyi.tools;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.stdio.StdioMcpTransport;
import dev.langchain4j.service.tool.ToolProvider;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.function.Supplier;

@ApplicationScoped
public class AwsCostExplorerToolProvider implements Supplier<ToolProvider> {

    private McpTransport transport;
    private McpClient mcpClient;
    private ToolProvider toolProvider;

    @Override
    public ToolProvider get() {
        if(toolProvider == null) {
            transport = new StdioMcpTransport.Builder()
                    .command(List.of("java", "-jar",
                            "D:\\Projects\\JavaProjects\\mcp-aws-cost-explorer\\target\\quarkus-app\\quarkus-run.jar"
                    ))
                    .logEvents(true)
                    .build();
            mcpClient = new DefaultMcpClient.Builder()
                    .transport(transport)
                    .build();
            toolProvider = McpToolProvider.builder()
                    .mcpClients(mcpClient)
                    .build();
        }
        return toolProvider;
    }
}
