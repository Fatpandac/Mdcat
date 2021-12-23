package Blocks;

import Filer.Filer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Code extends Blocks{
    private Filer filer;

    public Code(String code, String codeType) {
        super(code, codeType);
    }

    // Render code
    @Override
    public String render(String code, String codeType) {
        this.filer = new Filer(codeType.toLowerCase());
        if (!filer.write(code)) {
            System.out.println("Wrote fail!");
        } else {
            code = getHighlightedCode(code);
        }
        return code + System.lineSeparator();
    }

    private String getHighlightedCode(String code) {
        try {
            code = runRichToHighlightedCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            filer.delete();
        }
        return code;
    }

    private String runRichToHighlightedCode() throws IOException,
            InterruptedException {
        // Highlight code by rich with Python, so need run command
        String RICH_HIGHLIGHT_COMMAND = "python -m rich.syntax -cil ";
        Process proc = Runtime.getRuntime().exec(RICH_HIGHLIGHT_COMMAND + filer.getFilePath());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        proc.getInputStream()));
        ArrayList<String> output = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            output.add(line);
        }
        String highlightedCode = String.join(System.lineSeparator(), output);
        in.close();
        proc.waitFor();
        proc.destroy();
        return highlightedCode;
    }
}
