import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();
        Arrays.stream(numbers).forEach(n -> numSet.add(n));
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            if (!numSet.contains(i)) answer += i;
        }

        return answer;
    }
}