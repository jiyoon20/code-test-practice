import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // Count the occurrences of each tangerine size
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : tangerine) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        // Sort the entries by frequency in descending order
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int sum = 0;
        int index = 0;
        
        // Accumulate until the total count reaches or exceeds 'k'
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            sum += entry.getValue();
            index++;

            if (sum >= k) {  // Check if the current sum is enough
                answer = index;
                break;
            }
        }
        return answer;
    }
}
