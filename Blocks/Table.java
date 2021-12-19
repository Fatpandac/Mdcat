package Blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class Table extends Blocks {

    public Table(String table) {
        super(table);
    }

    // Render table
    @Override
    public String render(String table) {
        List<String> tables = List.of(table.split("\n"));

        // If table is haven't any data to render that return it and over
        if (tables.stream().parallel().allMatch(item -> item.length() == 0)) return table;

        // Split table by '|' and get each element in table
        String[][] tableElementsList =
                tables.stream().parallel().map(item -> item.split("\\|"))
                                .toArray(String[][]::new);

        // Format a new tables by table's elements
        List<String> formattedTables = formatTables(tableElementsList);

        // Get max length for each line in table
        int underlineLength = calculateUnderLineLength(tableElementsList);

        // Combine tables
        if (!formattedTables.isEmpty()) {
            formattedTables.remove(1);
            for (int i = 0; i < formattedTables.size(); i++) {
                if (i % 2 != 0) {
                    formattedTables.add(i, style.getTableUnderlineSign().repeat(underlineLength));
                }
            }
            return String.join("\n", formattedTables) + "\n";
        }
        return "|" + String.join("|\n|", tables) + "|\n";
    }

    private List<String> formatTables(String[][] tableElementsList) {
        int[] maxLengthOfColumns = getLongestEachColumn(tableElementsList);
        Function<String[], String> getTableLine =
                (String[] colsElements) ->
                        IntStream.range(0, colsElements.length).boxed()
                                .map(i ->
                                        colsElements[i] + " ".repeat(maxLengthOfColumns[i] - getLength.applyAsInt(colsElements[i])))
                                .reduce("", (a, b) -> a + b);

        Function<String[][], List<String>> getFormattedTables =
                (String[][] tableElements) ->
                        Arrays.stream(tableElements)
                                .map(getTableLine)
                                .collect(ArrayList::new,
                                        ArrayList::add,
                                        ArrayList::addAll);

        return getFormattedTables.apply(tableElementsList);
    }

    private int calculateUnderLineLength(String[][] tableElementsList) {
        return  Arrays.stream(getLongestEachColumn(tableElementsList)).sum();
    }

    // Get the longest element in each column
    private int[] getLongestEachColumn(String[][] tableElementsList) {
        int[] maxLengthOfColumns = new int[tableElementsList[0].length];
        for (String[] elements : tableElementsList) {
            for (int j = 0; j < elements.length; j++) {
                int displayLength = getLength.applyAsInt(elements[j]);
                if (displayLength > maxLengthOfColumns[j]) {
                    maxLengthOfColumns[j] = displayLength;
                }
            }
        }
        return maxLengthOfColumns;
    }

    // A lambda function variable -> Calculate display length of string
    private static final ToIntFunction<String> getLength =
            (String element) -> {
                int length = 0;
                String chinese = "[\u0391-\uFFE5]";
                for (int i  = 0; i < element.length(); i++) {
                    String temp = element.substring(i, i + 1);
                    if (temp.matches(chinese)) {
                        length += 2;
                    } else {
                        length += 1;
                    }
                }
                return length;
            };

}
