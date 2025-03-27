import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            // If the current char matches the last one, remove both
            if (sb.length() > 0 && s.charAt(i) == sb.charAt(sb.length()-1)) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(i));  // Otherwise, add it to the stack
            }
        }

        // If the string is empty after processing, return 1 (balanced)
        if (sb.length() == 0)
            answer = 1;
        
        return answer;  // Return the result
    }
}
