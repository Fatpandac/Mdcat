package Blocks;

import Render.Style;

public abstract class Blocks {
    String source;   // Block's source content
    String rendered;     // Rendered content
    String type;     // Block's type
    static final Style style = new Style();      // Block's style

    // For Bold, CheckBox, Emoji, Head, InsideCode, Italic, OrderList, Quote,
    // Strike, Table, UnorderedList
    Blocks(String source) {
        this.source = source;
        this.rendered = render(source);
    }

    // For Code
    Blocks(String source, String type) {
        this.source = source;
        this.type = type;
        this.rendered = render(source, type);
    }

    // For Bold, CheckBox, Emoji, Head, InsideCode, Italic, OrderList, Quote,
    // Strike, Table, UnorderedList
    public String render(String source) {
        return source;
    }

    // For Code
    public String render(String source, String type) {
        return source;
    }

    public String toString() {
        return rendered;
    }
}
