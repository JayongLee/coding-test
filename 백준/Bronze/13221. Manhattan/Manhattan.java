import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        String shortest = "";
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());
            int distance = Math.abs(goalX - X) + Math.abs(goalY - Y);
            if (distance < min) {
                shortest = line;
                min = distance;
            }
        }
        System.out.println(shortest);
    }
}