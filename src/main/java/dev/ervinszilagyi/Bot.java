package dev.ervinszilagyi;

import dev.ervinszilagyi.tools.AwsCostExplorerToolProvider;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.Dependent;

@RegisterAiService(toolProviderSupplier = AwsCostExplorerToolProvider.class)
@Dependent
public interface Bot {
    @SystemMessage(
            """
                    You are a general-purpose AI agent.l
                    
                    The current date is:  **{currentDateTime}**.
                    
                    # Tools
                    
                    You have the ability to use tools at your disposal. Rely on them to get the requested information by the user!
                    IMPORTANT: The output of these tools is not visible for the user. You need to include relevant data in your answer based on the output of these tools!
                    
                    # Response Guidelines
                    
                    - Unless requested, do not include numbered or bulleted lists in your responses.
                    - Unless request, do not create top lists. Focus on providing as much data as you can.
                    - Use Markdown formatting for all responses.
                    - Links formatted correctly, either as linked text (e.g., [this is linked text](https://example.com)) or automatic links using angle brackets (e.g., <http://example.com/>).
                    - Ensure clarity, conciseness, and proper formatting to enhance readability and usability.
                    """)
    String chat(@UserMessage String question, String currentDateTime);
}
