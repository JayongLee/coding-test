import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String sentence = br.readLine();
        String word = br.readLine();
        int count = 0;
        int index = 0;
        while (sentence.length() >= word.length() && index + word.length() <= sentence.length()) {
            String sub = sentence.substring(index, index + word.length());
            if (sub.equals(word)) {
                count++;
                sentence = sentence.substring(index + word.length());
                index = 0;
                continue;
            }
            index += 1;
        }

        System.out.println(count);
    }
}