import java.util.*;

class Solution {
    public long solution(int n) {
        if (n == 1) return 1;  // Base case for n = 1
        if (n == 2) return 2;  // Base case for n = 2
        
        long[] dp = new long[n + 1];  // DP array to store results
        dp[1] = 1;  // First number
        dp[2] = 2;  // Second number
        
        // Calculate sequence starting from 3 to n
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;  // Use modulo to avoid overflow
        }
     
        return dp[n];  // Return the nth number
    }
}