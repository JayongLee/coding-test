class Solution {
    
    private static int[] dx1 = {1, 0, -1, 0};
    private static int[] dy1 = {0, 1, 0, -1};
    private static int[] dx2 = {1, 1, -1, -1};
    private static int[] dy2 = {1, -1, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] map = new char[place.length][5];
            for (int j = 0; j < place.length; j++) {
                map[j] = place[j].toCharArray();
            }
            // 거리두기 체크
            if (isCorrect(map)) {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    private static boolean isCorrect(char[][] map) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (map[x][y] == 'P') {
                    // 응시자를 만났을때, 응시자 주변 검사
                    // 직선 거리
                    if (!checkStraight(map, x, y)) return false;
                    // 대각선 (맨허튼 거리 2)
                    if (!checkCross(map, x, y)) return false;
                }
            }
        }
        return true;
    }
    
    private static boolean checkCross(char[][] map, int x, int y) {
        for (int idx = 0; idx < 4; idx++) {
            int crossX = x + dx2[idx];
            int crossY = y + dy2[idx];
            if (validate(crossX, crossY) && map[crossX][crossY] == 'P') {
                // 파티션 쳐져 있는가?
                int checkX1 = x + dx2[idx];
                int checkY1 = y;
                int checkX2 = x;
                int checkY2 = y + dy2[idx];
                if (map[checkX1][checkY1] != 'X' || map[checkX2][checkY2] != 'X')
                    return false;
            }
        }
        return true;
    }
    
    private static boolean checkStraight(char[][] map, int x, int y) {
        for (int idx = 0; idx < 4; idx++) {
            // 맨허튼 거리가 1인 경우
            int nextX = x + dx1[idx];
            int nextY = y + dy1[idx];
            if (validate(nextX, nextY) && map[nextX][nextY] == 'P') {
                return false;
            }
            // 직선거리가 2인 경우
            int twoX = x + dx1[idx] * 2;
            int twoY = y + dy1[idx] * 2;
            if (validate(twoX, twoY) && map[twoX][twoY] == 'P') {
            // 파티션으로 안막혀있음 범죄
               if (map[nextX][nextY] != 'X')
                    return false;
            }
        }
        return true;
    }
    
    private static boolean validate(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5;
    }
}