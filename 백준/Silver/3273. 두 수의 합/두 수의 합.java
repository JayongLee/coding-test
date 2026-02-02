import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) max = arr[i];
        }

        Arrays.sort(arr);

        int count = 0;
        int start = 0;
        int end = n-1;
        
        while (start < end) {
            if (arr[start] + arr[end] == x) count++;
            if (arr[start] + arr[end] <= x) start++;
            else end--;
        }
        System.out.println(count);
    }
}
