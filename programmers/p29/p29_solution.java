import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Set<String>> map = new HashMap<>();
        
        // Group clothes by type
        for (String[] cloth : clothes) {
            map.computeIfAbsent(cloth[1], k -> new HashSet<>()).add(cloth[0]);
        }
        
        // Calculate possible combinations
        for (Set<String> set : map.values()) {
            answer *= (set.size() + 1); // Each type can be worn or skipped
        }
        
        return answer - 1; // Exclude the case where no clothes are worn
    }
}
