package Blocks;

public class Quote extends Blocks {

    public Quote(String quote) {
        super(quote);
    }

    // Render quote
    @Override
    public String render(String quote) {
        return style.getQuoteSign() + " " + quote.replaceAll(">+\\s*", "");
    }
}
