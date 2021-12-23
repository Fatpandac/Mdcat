package Parser;

import Render.Render;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // RegEx for match code
    private static final Pattern CODE_PATTERN =
            Pattern.compile("```([\\s\\S]*?)```[\\s]?");
    // RegEx for match Emoji
    private static final Pattern EMOJI_PATTERN =
            Pattern.compile(":(.*?):");
    // RegEx for match inside code
    private static final Pattern INSIDE_CODE_PATTERN =
            Pattern.compile("`{1,2}[^`](.*?)`{1,2}");
    // RegEx for match heading
    private static final Pattern HEAD_PATTERN =
            Pattern.compile("^(#+)(.*)$", Pattern.MULTILINE);
    // RegEx for match unordered list
    private static final Pattern UNORDERED_LIST_PATTERN =
            Pattern.compile("^(\\s?)*[-*+] +(.*)", Pattern.MULTILINE);
    // RegEx for match bold
    private static final Pattern BOLD_PATTERN =
            Pattern.compile("(\\*\\*|__)(.*?)\\1");
    // RegEx for match italic
    private static final Pattern ITALIC_PATTERN =
            Pattern.compile("([*_])(.*?)\\1");
    // RegEx for match strike
    private static final Pattern STRIKE_PATTERN =
            Pattern.compile("~~(.*?)~~");
    // RegEx for match quote
    private static final Pattern QUOTE_PATTERN =
            Pattern.compile("^([^\\n\\s]*?)(>+.*)", Pattern.MULTILINE);
    // RegEx for match order list
    private static final Pattern ORDER_LIST_PATTERN =
            Pattern.compile("^[\\s]*[0-9]+\\.(.*)", Pattern.MULTILINE);
    // RegEx for match table
    private static final Pattern TABLE_PATTERN =
            Pattern.compile("^(\\|[^\\n]+\\|\\r?\\n)((?:\\|:?[-]+:?)+\\|)(\\n(?:\\|[^\\n]+\\|\\r?\\n?)*)?$", Pattern.MULTILINE);
    // RegEx for match check box
    private static final Pattern CHECKBOX_PATTERN =
            Pattern.compile("^[-+*]\\s\\[[xX ]](.*)", Pattern.MULTILINE);

    // Slides container
    private final String markdown;

    // Render object
    private final Render render;

    public Parser(String content) {
        this.render = new Render();
        this.markdown = parsing(content);
    }

    public String parsing(String markdown) {
        // Parsing and rendering process of markdown
        return parserStrike(
               parserItalic(
               parserBold(
               parserEmoji(
               parserHead(
               parserOrderList(
               parserUnorderedList(
               parserInsideCode(
               parserCheckBox(
               parserQuote(
               parserTable(
               parserCode(
                        markdown))))))))))));
    }

    // To match in content by pattern and return a list of result
    private List<String> getMatchResult(String content, Pattern pattern) {
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    private String parserCheckBox(String content) {
        List<String> checkBoxes = getMatchResult(content, CHECKBOX_PATTERN);

        content = render.renderCheckBoxToContent(content, checkBoxes);
        return content;
    }


    private String parserTable(String content) {
        List<String> tables = getMatchResult(content, TABLE_PATTERN);

        content = render.renderTableToContent(content, tables);
        return content;
    }

    private String parserOrderList(String content) {
        List<String> orderLists = getMatchResult(content, ORDER_LIST_PATTERN);

        content = render.renderOrderListToContent(content, orderLists);
        return content;
    }

    private String parserQuote(String content) {
        List<String> quotes = getMatchResult(content, QUOTE_PATTERN);

        content = render.renderQuoteToContent(content, quotes);
        return content;
    }

    private String parserStrike(String content) {
        List<String> strikes = getMatchResult(content, STRIKE_PATTERN);

        content = render.renderStrikeToContent(content, strikes);
        return content;
    }

    private String parserItalic(String content) {
        List<String> italics = getMatchResult(content, ITALIC_PATTERN);

        content = render.renderItalicToContent(content, italics);
        return content;
    }

    private String parserBold(String content) {
        List<String> bolds = getMatchResult(content, BOLD_PATTERN);

        content = render.renderBoldToContent(content, bolds);
        return content;
    }

    private String parserUnorderedList(String content) {
        List<String> unorderedLists = getMatchResult(content, UNORDERED_LIST_PATTERN);

        content = render.renderUnorderedListToContent(content, unorderedLists);
        return content;
    }

    private String parserHead(String content) {
        List<String> heads = getMatchResult(content, HEAD_PATTERN);

        content = render.renderHeadToContent(content, heads);
        return content;
    }

    private String parserCode(String content) {
        List<String> codeBlocks = getMatchResult(content, CODE_PATTERN);

        content = render.renderCodeToContent(content, codeBlocks);
        return content;
    }

    private String parserInsideCode(String content) {
        List<String> insideCodes = getMatchResult(content, INSIDE_CODE_PATTERN);

        content = render.renderInsideCodeToContent(content, insideCodes);
        return content;
    }

    private String parserEmoji(String content) {
        List<String> emojis = getMatchResult(content, EMOJI_PATTERN);

        content = render.renderEmojiToContent(content, emojis);
        return content;
    }

    public String toString() {
       return String.join("", markdown);
    }

}
