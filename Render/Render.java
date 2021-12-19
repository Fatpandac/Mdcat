package Render;

import Blocks.*;

import java.util.ArrayList;
import java.util.List;

public class Render {

    public String renderCheckBoxToContent(String content, List<String> checkBoxes) {
        for (String checkBox : checkBoxes) {
            content = content.replace(checkBox,
                    new CheckBox(checkBox).toString());
        }
        return content;
    }

    public String renderTableToContent(String content, List<String> tables) {
        for (String table: tables) {
            content = content.replace(table, new Table(table).toString());
        }
        return content;
    }

    public String renderOrderListToContent(String content, List<String> orderLists) {
        int index = 1;
        for (String orderList: orderLists) {
            // Set index is one if it's the first in order list otherwise
            // index plus one
            index = (orderList.contains("\n")) ? 1 : index + 1;
            String newOrderList =
                    orderList.replaceFirst("[0-9]+\\.(.*?)", index + ". ");
            content = content.replace(orderList,
                    new OrderList(newOrderList).toString());
        }
        return content;
    }

    public String renderQuoteToContent(String content, List<String> quotes) {
        for (String quote: quotes) {
            content = content.replace(quote, new Quote(quote).toString());
        }
        return content;
    }

    public String renderStrikeToContent(String content, List<String> strikes) {
        for (String strike: strikes) {
            content = content.replace(strike, new Strike(strike).toString());
        }
        return content;
    }

    public String renderItalicToContent(String content, List<String> italics) {
        for (String italic: italics) {
            content = content.replace(italic, new Italic(italic).toString());
        }
        return content;
    }

    public String renderBoldToContent(String content, List<String> bolds) {
        for (String bold: bolds) {
            content = content.replace(bold, new Bold(bold).toString());
        }
        return content;
    }

    public String renderUnorderedListToContent(String content,
                                               List<String> unorderedLists) {
        for (String unorderedList: unorderedLists) {
            content = content.replace(unorderedList,
                    new UnorderedList(unorderedList).toString());
        }
        return content;
    }

    public String renderHeadToContent(String content, List<String> heads) {
        for (String head: heads) {
            content = content.replace(head, new Head(head).toString());
        }
        return content;
    }

    public String renderCodeToContent(String content, List<String> codeBlocks) {
        // Filter code languages and code
        List<String> codes = new ArrayList<>();
        List<String> codesType = new ArrayList<>();
        codeBlocks.forEach(item -> {
            String[] splits = item.split("\n");
            codesType.add(splits[0].replace("```", ""));
            codes.add(item.replace(splits[0] + "\n", "").replace("\n```", ""));
        });
        for (int i = 0; i < codes.size(); i++) {
            content = content.replace(codeBlocks.get(i),
                            new Code(codes.get(i), codesType.get(i)).toString());
        }
        return content;
    }

    public String renderInsideCodeToContent(String content, List<String> insideCodes) {
        for (String insideCode: insideCodes) {
            content = content.replace(insideCode,
                    new InsideCode(insideCode.replace("`", "")).toString());
        }
        return content;
    }

    public String renderEmojiToContent(String content, List<String> emojis) {
        for (String emoji: emojis) {
            content = content.replace(emoji,
                    new Emoji(emoji.replace(":", "")).toString());
        }
        return content;
    }
}
