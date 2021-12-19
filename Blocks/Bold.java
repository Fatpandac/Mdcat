package Blocks;

public class Bold extends Blocks {

    public Bold(String bold) {
        super(bold);
    }

    @Override
    public String render(String bold) {
        String FIRST_BOLD_SIGN_PATTERN = "^(\\*\\*|__)";
        String LAST_BOLD_SIGN_PATTERN = "(\\*\\*|__)$";
        return "\033[1m" +bold.replaceAll(FIRST_BOLD_SIGN_PATTERN, "")
                    .replaceAll(LAST_BOLD_SIGN_PATTERN, "") + "\033[0m";
    }
}
