package dev.ervinszilagyi.io;

import com.vladsch.flexmark.profile.pegdown.Extensions;
import com.vladsch.flexmark.profile.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

public interface Cli {
    String readLine(String prompt);

    void printMdFormatted(String line);

    DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL
    );

    MutableDataSet FORMAT_OPTIONS = new MutableDataSet();
}
