import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> sumSet = new HashSet<>();  // Set to track unique sums
        
        // Create a new array by repeating the original array to handle circularity
        int[] newArray = new int[elements.length * 2];
        for (int i = 0; i < elements.length * 2; i++) {
            int index = i % elements.length;  // Wrap around to the start of the array
            newArray[i] = elements[index];
        }
        
        int sum = 0;
        // Iterate through all possible subarrays
        for (int j = 0; j < elements.length; j++) {
            for (int l = j; l < elements.length + j; l++) {
                sum = sum + newArray[l];  // Add element to the current sum
                sumSet.add(sum);  // Add the sum to the set
            }
            sum = 0;  // Reset sum for the next subarray
        }
    
        answer = sumSet.size();  // The number of unique sums
        return answer;
    }
}
