package Render;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Style {
    private String CHECK_BOX = "[✓]";
    private String UNCHECK_BOX = "[ ]";
    private final RGBColor H1_COLOR = new RGBColor(32, 12, 234);
    private String H1_SIGN = "██";
    private final RGBColor H2_COLOR = new RGBColor(234, 45, 134);
    private String H2_SIGN = "▓▓▓";
    private final RGBColor H3_COLOR = new RGBColor(34, 56, 128);
    private String H3_SIGN = "▒▒▒▒";
    private final RGBColor H4_COLOR = new RGBColor(65, 45, 78);
    private String H4_SIGN = "░░░░░";
    private final RGBColor H5_COLOR = new RGBColor(45, 67, 89);
    private String H5_SIGN = "";
    private final RGBColor H6_COLOR = new RGBColor(89, 123, 67);
    private String H6_SIGN = "";
    private String TABLE_UNDERLINE_SIGN = "─";
    private String UNORDERED_LIST_SIGN = ".";
    private String QUOTE_SIGN = "│";

    public Style() {
        Stream<String> configContent = loadFile();
        inti(configContent);
    }

    public Stream<String> loadFile() {
        String STYLE_FILE_PATH = "assets/style.txt";
        Stream<String> lines = Stream.empty();
        try {
            lines = Files.lines(Path.of(STYLE_FILE_PATH));
        } catch (IOException e) { e.printStackTrace(); }
        return lines;
    }

    public void inti(Stream<String> configContent) {
        Pattern configPattern = Pattern.compile("^(.*):(.*)$");
        configContent.forEach(line -> {
            Matcher matcher = configPattern.matcher(line);
            if (matcher.find()) {
                String configOptions = matcher.group(1).trim();
                String configValue = matcher.group(2).trim();
                switch (configOptions)
                {
                    case "CheckBox":
                        CHECK_BOX = configValue;
                        break;
                    case "UncheckBox":
                        UNCHECK_BOX = configValue;
                        break;
                    case "TableUnderlineSign":
                        TABLE_UNDERLINE_SIGN = configValue;
                        break;
                    case "UnorderedListSign":
                        UNORDERED_LIST_SIGN = configValue;
                        break;
                    case "QuoteSign":
                        QUOTE_SIGN = configValue;
                        break;
                    case "H1Color":
                        H1_COLOR.setColor(configValue);
                        break;
                    case "H1Sign":
                        H1_SIGN = configValue;
                        break;
                    case "H2Color":
                        H2_COLOR.setColor(configValue);
                        break;
                    case "H2Sign":
                        H2_SIGN = configValue;
                        break;
                    case "H3Color":
                        H3_COLOR.setColor(configValue);
                        break;
                    case "H3Sign":
                        H3_SIGN = configValue;
                        break;
                    case "H4Color":
                        H4_COLOR.setColor(configValue);
                        break;
                    case "H4Sign":
                        H4_SIGN = configValue;
                        break;
                    case "H5Color":
                        H5_COLOR.setColor(configValue);
                        break;
                    case "H5Sign":
                        H5_SIGN = configValue;
                        break;
                    case "H6Color":
                        H6_COLOR.setColor(configValue);
                        break;
                    case "H6Sign":
                        H6_SIGN = configValue;
                        break;
                }
            }
       });
    }

    public String getCheckBox() {
        return CHECK_BOX;
    }

    public String getUncheckBox() {
        return UNCHECK_BOX;
    }

    public RGBColor getH1Color() {
        return H1_COLOR;
    }

    public String getH1Sign() {
        return H1_SIGN;
    }

    public RGBColor getH2Color() {
        return H2_COLOR;
    }

    public String getH2Sign() {
        return H2_SIGN;
    }

    public RGBColor getH3Color() {
        return H3_COLOR;
    }

    public String getH3Sign() {
        return H3_SIGN;
    }

    public RGBColor getH4Color() {
        return H4_COLOR;
    }

    public String getH4Sign() {
        return H4_SIGN;
    }

    public RGBColor getH5Color() {
        return H5_COLOR;
    }

    public String getH5Sign() {
        return H5_SIGN;
    }

    public RGBColor getH6Color() {
        return H6_COLOR;
    }

    public String getH6Sign() {
        return H6_SIGN;
    }

    public String getTableUnderlineSign() {
        return TABLE_UNDERLINE_SIGN;
    }

    public String getUnorderedListSign() {
        return UNORDERED_LIST_SIGN;
    }

    public String getQuoteSign() {
        return QUOTE_SIGN;
    }
}
