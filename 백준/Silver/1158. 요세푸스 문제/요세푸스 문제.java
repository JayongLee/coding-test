import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while (!queue.isEmpty()) {
            int index = 1;
            while (index < K) {
                Integer poll = queue.poll();
                queue.add(poll);
                index++;
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length() -1, ">");
        System.out.println(sb);
    }
}