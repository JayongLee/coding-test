import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String trans = Integer.toString(n, k);
        String[] nums = trans.split("0");
        
        long[] longNums = Arrays.stream(nums)
            .filter(num -> !num.isEmpty())
            .mapToLong(num -> Long.parseLong(num))
            .toArray();
        
        int answer = 0;
        
        if (longNums.length == 0) return 0;
        
        for (long longNum : longNums) {
            if (isPrime(longNum))
                answer += 1;
        }
        
        return answer;
    }
    
    private static boolean isPrime(long num) {
        if (num == 2) return true;
        if (num % 2 == 0 || num < 2) return false;
        
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}