package Blocks;

public class CheckBox extends Blocks{

    public CheckBox(String checkBox) {
        super(checkBox);
    }

    // Render check box
    @Override
    public String render(String checkBox) {
        return checkBox.replaceAll("^[-+*]\\s\\[[xX ]]",
                   (checkBox.indexOf("[x]") + checkBox.indexOf("[x]") > 0) ?
                         style.getCheckBox() : style.getUncheckBox());
    }
}
