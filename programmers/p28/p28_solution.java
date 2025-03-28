import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];
        
        int index = 0;
        for (long i = left; i <= right; i++) {
            // Calculate value at position i without creating the full 2D array
            answer[index++] = (int) (Math.max(i / n, i % n) + 1);
        }        
       
        return answer;
    }
}
