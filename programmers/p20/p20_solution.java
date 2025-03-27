import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;   
        int index = 0;
        
        Arrays.sort(people);  // Sort the people array in ascending order
    
        // Try pairing the heaviest person with the lightest
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {  // Check if they fit together
                index++;  // Pair the lightest with the heaviest
            }
            answer++;  // Increment the number of boats used
        }
        
        return answer;  // Return the minimum number of boats
    }
}
