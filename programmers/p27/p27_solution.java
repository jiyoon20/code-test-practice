import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // Create a list with the items and their required quantities
        List<String> wantList = new ArrayList<>();
        
        for (int l = 0; l < want.length; l++) {
            for (int k = 0; k < number[l]; k++) {
                wantList.add(want[l]);
            }
        }
        
        // Check every 10-day discount period
        for (int i = 0; i <= discount.length - 10; i++) {
            List<String> copyList = new ArrayList<>(wantList);  // Make a copy of wantList
            
            // Try to match the discount items with the required items
            for (int j = i; j < i + 10; j++) {
                if (copyList.contains(discount[j])) {  // If the item matches, remove it from the list
                    copyList.remove(discount[j]);
                } else {
                    break;  // If an item doesn't match, stop checking this period
                }
            }
            
            // If all required items are matched, increment the answer
            if (copyList.size() == 0)
                answer++;
        }
        return answer;
    }
}
