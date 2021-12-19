package Blocks;

public class Italic extends Blocks {

    public Italic(String italic) {
        super(italic);
    }

    // Render italic
    @Override
    public String render(String italic) {
        return "\033[3m" + italic.replaceAll("[*_]", "") + "\033[0m";
    }
}
