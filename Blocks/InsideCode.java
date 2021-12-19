package Blocks;

public class InsideCode extends Blocks {

    public InsideCode(String insideCode) {
        super(insideCode);
    }

    // Render code
    @Override
    public String render(String code) {
        // \u200b is a 'ZERO WIDTH SPACE' use it hold the sign don't move
        return "\033[48;5;246m\033[38;5;160m " + code + " \033[0m";
    }
}
