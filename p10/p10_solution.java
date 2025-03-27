import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        // Parse today's date into an integer array [year, month, day]
        String[] parts = today.split("\\.");
        int[] now = new int[3];
        for (int i = 0; i < parts.length; i++)
            now[i] = Integer.parseInt(parts[i]);
        
        // Store terms and their respective duration in a HashMap
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        
        // Process each privacy record
        for (int j = 0; j < privacies.length; j++) {
            String[] pr_temp = privacies[j].split(" ");
            String[] parts2 = pr_temp[0].split("\\.");
            
            // Convert registration date into an integer array [year, month, day]
            int[] reg_date = new int[3];
            for (int i = 0; i < parts2.length; i++)
                reg_date[i] = Integer.parseInt(parts2[i]); 

            // Check if the privacy record is expired
            if (isExpired(now, reg_date, map.get(pr_temp[1]))) {
                list.add(j + 1); // Store the index (1-based)
            }
        }
        
        // Convert list to array
        answer = new int[list.size()];
        for(int k = 0; k < list.size(); k++)
            answer[k] = list.get(k);
        
        return answer;
    }
    
    /**
     * Checks if a privacy record is expired based on today's date.
     * @param now      Current date [year, month, day]
     * @param reg_date Registration date [year, month, day]
     * @param duration Valid duration in months
     * @return true if expired, false otherwise
     */
    public boolean isExpired(int[] now, int[] reg_date, int duration) {
        int year = reg_date[0];
        int month = reg_date[1] + duration;
        int day = reg_date[2] - 1; // Expiry is the day before the exact term ends

        // Adjust month and year when months exceed 12
        while (month > 12) {
            year++;
            month -= 12;
        }

        // Handle case when day becomes 0 (move to previous month)
        if (day == 0) {
            month--;
            if (month == 0) { 
                year--;
                month = 12;
            }
            day = 28; // Assume all months have 28 days for simplicity
        }

        // Compare dates to determine expiration
        if (now[0] > year) return true;
        if (now[0] == year && now[1] > month) return true;
        if (now[0] == year && now[1] == month && now[2] > day) return true;

        return false;  
    }
}
