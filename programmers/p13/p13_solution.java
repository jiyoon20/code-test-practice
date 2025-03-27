import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // Mapping keypad characters to their (row, col) positions
        Map<Character, int[]> keypadMap = new HashMap<>();
        
        int[][] pos = {
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 1}, {3, 2}
        };
        
        char[] key = {
            '1', '2', '3',
            '4', '5', '6',
            '7', '8', '9',
            '*', '0', '#'
        };

        // Populate the keypad map with positions
        for (int i = 0; i < key.length; i++)
            keypadMap.put(key[i], pos[i]);
        
        // Initial positions of the left and right fingers
        int[] f_r = keypadMap.get('*');
        int[] f_l = keypadMap.get('#');

        // Process each number in the sequence
        for (int i = 0; i < numbers.length; i++) {
            char ch = (char) (numbers[i] + '0');

            // Left hand numbers (1, 4, 7)
            if (ch == '1' || ch == '4' || ch == '7') {
                answer += "L";
                f_l = keypadMap.get(ch);
            } 
            // Right hand numbers (3, 6, 9)
            else if (ch == '3' || ch == '6' || ch == '9') {
                answer += "R";
                f_r = keypadMap.get(ch);
            } 
            // Center numbers (2, 5, 8, 0) - decide based on distance
            else {
                int[] now = keypadMap.get(ch);
                
                int distR = distance(f_r, now);
                int distL = distance(f_l, now);

                if (distR < distL) {
                    answer += "R";
                    f_r = now;
                } 
                else if (distR > distL) {
                    answer += "L";
                    f_l = now;
                } 
                else {
                    if (hand.equals("right")) {
                        answer += "R";
                        f_r = now;
                    } 
                    else {
                        answer += "L";
                        f_l = now;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * Calculates the Manhattan distance between two positions on the keypad.
     */
    public int distance(int[] first, int[] now) {
        return Math.abs(first[0] - now[0]) + Math.abs(first[1] - now[1]);
    }
}
