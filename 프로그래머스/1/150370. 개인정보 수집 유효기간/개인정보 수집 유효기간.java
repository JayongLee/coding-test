import java.util.*;

class Solution {
    
    private static final int[] multiplies = new int[] { 336, 28, 1 };
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> type = new HashMap<>();
        List<Integer> ansList = new ArrayList<>();
        initMap(type, terms);
        long todayNum = dayToNum(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] dateAndType = privacies[i].split(" ");
            long num = dayToNum(dateAndType[0]);
            long diff = todayNum - num;
            if (diff >= type.get(dateAndType[1]) * 28) {
                ansList.add(i + 1);
            }
        }
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static long dayToNum(String day) {
        String[] date = day.split("[.]");
        long num = 0L;
        
        for (int i = 0; i < date.length; i++) {
            long dateToLong = Long.parseLong(date[i]);
            num += dateToLong * multiplies[i];
        }
        return num;
    }
    
    private static void initMap(Map<String, Integer> type, String[] terms) {
        for (String term : terms) {
            String[] keyValue = term.split(" ");
            String key = keyValue[0];
            int value = Integer.parseInt(keyValue[1]);
            type.put(key, value);
        }
    }
}