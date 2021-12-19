package Blocks;

public class Strike extends Blocks {

    public Strike(String strike) {
        super(strike);
    }

    // Render strike
    @Override
    public String render(String strike) {
        return "\033[9m" + strike.replace("~", "") + "\033[0m";
    }
}
