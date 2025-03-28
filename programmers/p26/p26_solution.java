import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // Check if the initial string is a valid parentheses sequence
        if (checkParen(s))
            answer++;
        
        // Rotate the string and check all possible rotations
        for (int i = 0; i < s.length() - 1; i++) {
            s = s.substring(1) + s.charAt(0);  // Rotate string by moving the first character to the end
            if (checkParen(s))  // Check if the rotated string is valid
                answer++;
        }
        return answer;
    }
    
    // Check if the string has valid parentheses
    public boolean checkParen(String s) {
        boolean result = false;
        Stack <Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));  // Push the character to the stack
            
            // If there are two characters and they form a valid pair, pop them
            if (stack.size() >= 2 && isPair(stack.get(stack.size() - 2), stack.get(stack.size() - 1))) {
                stack.pop();
                stack.pop();
            }
        }
    }
}
        
