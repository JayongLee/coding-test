import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] testCase = br.readLine().split(" ");
            int dx = Math.abs(Integer.parseInt(testCase[0]) - Integer.parseInt(testCase[3]));
            int dy = Math.abs(Integer.parseInt(testCase[1]) - Integer.parseInt(testCase[4]));
            int floor1 = Integer.parseInt(testCase[2]);
            int floor2 = Integer.parseInt(testCase[5]);
            sb.append(floor1 + floor2 + dx + dy).append("\n");
        }

        System.out.println(sb);
    }
}