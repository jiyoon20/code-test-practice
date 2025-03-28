import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);  // Sort the array to calculate LCM in order
        
        if (arr.length == 1)  // If only one number, return it directly
            return arr[0];
        
        int result = lcm(arr[0], arr[1]);  // Start with the LCM of the first two numbers
        
        for (int i = 2; i < arr.length; i++) {
            result = lcm(result, arr[i]);  // Update LCM with each subsequent number
        }
        return result;  // Return the final LCM
    }
    
    public int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = b;
            b = a % b;  // Find remainder
            a = temp;  // Update a with b
        }
        return b;  // Return the greatest common divisor
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);  // Calculate LCM using the formula: LCM = (a * b) / GCD
    }
}
