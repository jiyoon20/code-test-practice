class Solution {
    public int solution(int n) {
        // Count the number of 1s in the binary representation of 'n'
        int count_n = Integer.bitCount(n);
        
        // Start checking from the next number
        int number = n + 1;
        
        // Keep checking until the number of 1s in the binary representation matches the original number 'n'
        while (Integer.bitCount(number) != count_n)
            number++; // Increment the number to check the next one
        
        return number; // Return the number that has the same number of 1s in its binary representation
    }
}