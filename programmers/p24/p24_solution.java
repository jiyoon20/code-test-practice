import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> wordSet = new HashSet<>();  // Set to track used words
        
        wordSet.add(words[0]);  // Add the first word
        
        for (int i = 1; i < words.length; i++) {
            int len = words[i-1].length();
            
            // Check if the current word does not start with the previous word's last letter or if it's already used
            if ((words[i-1].charAt(len-1) != words[i].charAt(0)) || wordSet.contains(words[i])) {
                // Calculate the player and round number
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                
                return answer;  // Return when a rule is broken
            } 
            wordSet.add(words[i]);  // Add the current word to the set
        }
        
        return answer;  // Return [0, 0] if no rule is broken
    }
}
