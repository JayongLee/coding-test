import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];

        String word = br.readLine();
        for (char c : word.toCharArray()) {
            alpha[c - 'a'] += 1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i : alpha) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}