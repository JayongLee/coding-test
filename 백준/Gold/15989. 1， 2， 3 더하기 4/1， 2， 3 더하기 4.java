import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        dp = new int[10_001];
        for (int i = 0; i <= 10_000; i++) {
            dp[i] = 1; // 1로만 구성된 경우
        }

        for (int i = 2; i <= 10_000; i++) {
            dp[i] += dp[i - 2]; // 2 추가한 경우
        }

        for (int i = 3; i <= 10_000; i++) {
            dp[i] += dp[i - 3]; // 3 추가한 경우
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}