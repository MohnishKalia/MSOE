package poet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Poem {
    public static void main(String[] args) throws IOException {
        //get lines of the file and split into words
        List<String[]> lines = Files.readAllLines(Paths.get("src/poet/stuff.txt")).stream().map(line -> line.split(" ")).collect(Collectors.toList());
        
        //take out the last line
        String[] codes = lines.remove(lines.size() - 1);

        String message = "";

        for (String code : codes) {
            int lineNumber = Integer.parseInt("" + code.charAt(0) + code.charAt(1)) - 1;
            int wordNumber = parseChar(code.charAt(2)) - 1;
            int letterNumber = parseChar(code.charAt(3)) - 1;

            String[] words = lines.get(lineNumber);
            String word = words[wordNumber];
            char letter = word.charAt(letterNumber);
            message += letter;
        }

        System.out.println("Message: " + message);
    }

    public static int parseChar(char c) {
        return Integer.parseInt("" + c);
    }
}