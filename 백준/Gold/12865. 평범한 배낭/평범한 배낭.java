import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] things = new int[N+1][2];
        init(N, K, things);

        int[][] bags = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (things[i][0] > w)
                    bags[i][w] = bags[i-1][w];
                else
                    bags[i][w] = Math.max(bags[i-1][w], bags[i-1][w-things[i][0]] + things[i][1]);
            }
        }

        System.out.println(bags[N][K]);
    }

    private static void init(int N, int K, int[][] things) throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken()); // 무게
            things[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }
    }
}