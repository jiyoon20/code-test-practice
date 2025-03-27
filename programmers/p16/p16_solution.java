import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; // Array to store results
        int count_zero = 0; // Counter to track the number of '0' characters removed
        int index = 0; // Counter for the number of transformations

        StringBuilder sb = new StringBuilder(s); // Use StringBuilder for efficient string manipulation
        
        // Continue the transformation until the string length becomes 1
        while (sb.length() != 1) {
            
            // Remove all '0's from the string
            while (sb.indexOf("0") != -1) {
                int szero = sb.indexOf("0"); // Find the index of the first '0'
                sb.deleteCharAt(szero); // Remove the '0' at the found index
                count_zero++; // Increment the zero counter
            }
            
            // Convert the current length of the string to binary and update the string
            int len = sb.length(); 
            sb = new StringBuilder(Integer.toBinaryString(len));        
            index++; // Increment the transformation count
        }
        
        answer[0] = index; // Store the number of transformations
        answer[1] = count_zero; // Store the number of '0's removed
        return answer; // Return the result
    }
}