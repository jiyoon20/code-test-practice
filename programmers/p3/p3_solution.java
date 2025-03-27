import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // Create a map to store the count of reports received by each user
        Map<String, Integer> map = new HashMap<>();
        for (String id: id_list)
            map.put(id, 0);
        
        // Create a map to store the list of users who reported each user
        Map<String, Set<String>> reported = new HashMap<>();
        for(String id: id_list){
            reported.put(id, new HashSet<>());
        }
        
        // Process each report and store unique reporters for each reported user
        for(int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            reported.get(str[1]).add(str[0]); // Add reporter to the set of reported user
        }
        
        // Check if the reported user has been reported at least k times
        for(Set<String> data : reported.values()){
            if(data.size() >= k){
                // Increase the mail notification count for reporters
                for(String reporter : data) {
                    map.put(reporter, map.get(reporter) + 1);
                }
            }            
        }
        
        // Convert the map values to an array in the order of id_list
        for (int i = 0; i < id_list.length; i++)
            answer[i] = map.get(id_list[i]);
        
        return answer;
    }
}