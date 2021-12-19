package Blocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Emoji extends Blocks{
    static String EMOJI_FILE_PATH = "assets/emoji.txt";

    public Emoji(String emoji) {
        super(emoji);
    }

    // Render Emoji
    @Override
     public String render(String value) {
        String result = ":" + value + ":";
        try {
            // Open emoji.txt and read
            Stream<String> lines = Files.lines(Paths.get(EMOJI_FILE_PATH));
            // filter lines that contain value and get the first element in it
            result = lines.filter(line -> line.split(":")[0].equals(value))
                    .map(item -> item.split(":")[1])
                    .findFirst().orElse(value);
            lines.close();
        } catch (IOException e) { e.printStackTrace(); }
        return result;
    }
}