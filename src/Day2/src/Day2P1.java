import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2P1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Day2.in"));
        int counter2 = 0;
        int counter3 = 0;
        while (input.hasNext()) {
            String curLine = input.nextLine();
            Map<Character, Integer> charFreq = new HashMap<>();
            for (char curChar: curLine.toCharArray()) {

                charFreq.put(curChar, charFreq.getOrDefault(curChar, 0) + 1);
            }
            counter2 = (charFreq.containsValue(2)) ? counter2 + 1 : counter2;
            counter3 = (charFreq.containsValue(3)) ? counter3 + 1 : counter3;
        }
        System.out.println(counter2 * counter3);
    }
}
