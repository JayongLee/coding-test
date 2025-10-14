import java.util.*;

class Solution {
    
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        List<Integer[]> costList = new ArrayList<>();
        Arrays.stream(costs).forEach(cost -> {
            costList.add(new Integer[]{cost[0], cost[1], cost[2]});
        });
        
        costList.sort((o1, o2) -> {
            return  o1[2] - o2[2];
        });
                
        int price = 0;
        for (Integer[] cost : costList) {
            int start = cost[0];
            int end = cost[1];
            if (root(start) != root(end)) { // 사이클이 아닌 경우
                price += cost[2];
                union(Math.min(start, end), Math.max(start, end));
            }
        }
        return price;
    }
    
    private static int root(int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = root(parent[x]);
            return parent[x];
        }
    }
    
    private static void union(int x, int y) {
        int xParent = root(x);
        int yParent = root(y);
        
        if (xParent == yParent) return;
        
        parent[yParent] = xParent;
    }
}