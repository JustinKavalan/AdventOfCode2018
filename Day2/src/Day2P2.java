import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day2P2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("Day2.in"));

        Collections.sort(input);
        String prevLine = "";
        for (String curLine: input) {
            if (prevLine.length() == curLine.length()) {
                int diff = 0;
                String ans = "";
                for (int i = 0; i < curLine.length(); i++) {
                    if (prevLine.charAt(i) != curLine.charAt(i)) {
                        diff++;
                        ans = curLine.substring(0, i) + curLine.substring(i + 1);
                    }
                }

                if (diff == 1) {
                    System.out.println(ans);
                }
            }
            prevLine = curLine;
        }
    }
}
