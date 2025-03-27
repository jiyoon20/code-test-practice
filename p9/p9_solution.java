import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        // Create a HashMap to store player names and their corresponding index positions
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);
        
        // Process each calling (overtaking event)
        for (int i = 0; i < callings.length; i++) {
            int index = map.get(callings[i]); // Get current index of the called player
            
            // Identify the player in front (who gets overtaken)
            String front = players[index - 1];
            
            // Swap the positions of the two players
            players[index] = front;
            players[index - 1] = callings[i];
            
            // Update their positions in the HashMap
            map.put(callings[i], index - 1);
            map.put(front, index);            
        }
               
        return players;
    }
}
