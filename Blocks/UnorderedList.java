package Blocks;

public class UnorderedList extends Blocks {

    public UnorderedList(String unorderedList) {
        super(unorderedList);
    }

    // Render unordered list
    @Override
    public String render(String unorderedList) {
        return unorderedList.replaceFirst("[-*+]", style.getUnorderedListSign());
    }
}
