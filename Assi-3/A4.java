import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;

public class A4 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;
        String content = Files.lines(Paths.get(args[0]))
            .map(l -> l.replaceAll("//.*", ""))
            .collect(Collectors.joining("\n"));
        int chars = content.replaceAll("\\s", "").length();
        int lines = (int) content.lines().filter(l -> !l.isBlank()).count();
        int words = content.split("\\s+").length;
        System.out.println("Chars: " + chars);
        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
    }
}