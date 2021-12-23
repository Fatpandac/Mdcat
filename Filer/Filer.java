package Filer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Filer {
    private final Path filePath;

    public Filer(String fileType) {
        String fileName = "slides_temp";
        this.filePath = Path.of("./" + fileName + "." + fileType);
    }

    public Filer(Path filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath.toString();
    }

    public boolean write(String content) {
        try {
            Files.writeString(filePath, content,
                    StandardCharsets.UTF_8);
        } catch (IOException e) { e.printStackTrace(); }
        return true;
    }

    public String read() {
        String content = "";
        try {

            content = Files.readString(filePath,
                    StandardCharsets.UTF_8);
        } catch (IOException e) { e.printStackTrace(); }
        return content;
    }

    public void delete() {
        try {
            Files.deleteIfExists(filePath);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
