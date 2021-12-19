import Filer.Filer;
import Parser.Parser;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class mdcat {
    public static void main(String[] args) {
        start(args);
    }

    public static  void start(String[] args) {
        boolean systemInAvailableIsEmpty = false;
        try {
            systemInAvailableIsEmpty = System.in.available() == 0;
        } catch (Exception ignored) { }
        if (args.length >= 1&& systemInAvailableIsEmpty) {
            if (args.length == 1) {
                boolean isMarkdownFile = args[0].endsWith(".md");
                if (isMarkdownFile) {
                    startByFile(args);
                } else if (args[0].equals("-h") || args[0].equals("--help")) {
                    printHelp();
                    System.exit(1);
                } else {
                    printErrorFileTypeNotSupported();
                    System.exit(1);
                }
            } else {
                printErrorOpenTooManyFile();
                System.exit(1);
            }
        } else if (!systemInAvailableIsEmpty) {
            startByStdin();
        } else {
            printErrorNoInput();
            System.exit(1);
        }
    }

    private static void startByFile(String[] args) {
        Path filePath = Path.of(System.getProperty("user.dir"), args[0]);
        if (new File(String.valueOf(filePath)).exists()) {
            Filer filer = new Filer(filePath);
            // \r\n is Windows line separator, change it to Unix line
            // separator that is \n
            String content = filer.read().replace("\r\n", "\n");
            System.out.println(new Parser(content));
        } else {
            printErrorFileNotFound();
            System.exit(1);
        }
    }

    private static void printErrorFileNotFound() {
        System.out.println("Error: File not found!");
    }

    private static void  printHelp() {
        System.out.println("Mdcat by Fatpandac");
        System.out.println("Usage:\n  mdcat <file.md>");
    }

    private static void printErrorFileTypeNotSupported() {
        System.out.println("Error: File type not supported");
        System.out.println("Usage:\n  mdcat <file.md>");
    }

    private static void printErrorOpenTooManyFile() {
        System.out.println("Error: Too many files open");
        System.out.println("Usage:\n  mdcat <file.md>");
    }

    private static void printErrorNoInput() {
        System.out.println("Error: No input");
        System.out.println("Usage:\n  mdcat <file.md>");
    }

    private static void startByStdin() {
        // Get input from stdin by pipe
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        scanner.close();
        String content = String.join("\n", list);
        System.out.println(new Parser(content));
    }
}
