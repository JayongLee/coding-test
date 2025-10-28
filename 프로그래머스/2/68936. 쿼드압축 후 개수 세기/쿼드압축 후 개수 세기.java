class Solution {
    private static int[][] map;
    private static int zero; 
    private static int one;
    private static int[] dx = new int[]{0, 1, 0, 1};
    private static int[] dy = new int[]{0, 0, 1, 1};
    
    public int[] solution(int[][] arr) {
        map = arr;
        zero = 0; one = 0;
        int len = arr[0].length;
        
        quad(len/2, 0, 0);
        
        int[] answer = new int[]{zero, one};
        return answer;
    }
    
    private static void quad(int half, int startX, int startY) {
        
        
        if (half == 0) {
            for (int i = 0; i < 4; i++) {
                int num = map[startX + dx[i]*1][startY + dy[i]*1];
                if (num == 0) zero++;
                else one++;
            }
            return;
        }
        
        int[] tmp = new int[4];
        // 같은 값인지 체크
        tmp[0] = check(half, startX, startY);
        tmp[1] = check(half, startX + half, startY);
        tmp[2] = check(half, startX, startY + half);
        tmp[3] = check(half, startX + half, startY + half);
        
        int prev = tmp[0];
        boolean flag = true;
        for (int i = 1; i < 4; i++) {
            if (prev != tmp[i]) {
                flag = false;
                break;
            } 
        }
        
        if (flag && (prev != -1)) {
            if (prev == 0) zero++;
            else one++;
            return;
        }
        
        
        for (int i = 0; i < 4; i++) {
            int state = tmp[i];
            if (state == -1) {
                quad(half/2, startX + dx[i]*half, startY + dy[i]*half);
            } else if (state == 0) {
                zero += 1;
            } else one += 1;
        }
    }
    
    private static int check(int n, int x, int y) {
        int flagNum = map[x][y];
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (map[i][j] != flagNum)
                    return -1;
            }
        }
        return flagNum;
    }
}