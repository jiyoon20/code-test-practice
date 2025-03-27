class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // Iterate through each schedule
        for(int i = 0; i < schedules.length; i++){
            int sc = schedules[i]; // Scheduled time
            
            int ontime = sc + 10; // Considered on-time if within 10 minutes
            
            // Adjust time if minutes exceed 59 (convert to proper hour format)
            if((ontime % 100) > 59) {
                int hour = ontime / 100;
                int minute = ontime % 100;
                
                ontime = (hour + 1) * 100 + (minute - 60);
            }
            
            boolean check = true;
            // Check each day's time log
            for(int j = 0; j < timelogs[i].length; j++){
                int week = (startday + j) % 7; // Determine the day of the week
                
                if (week != 6 && week != 0) { // Exclude weekends (Saturday=6, Sunday=0)
                    if(ontime < timelogs[i][j]) { // If arrival time is later than on-time limit
                        check = false;
                    }
                }                    
            }
            
            // If all working days are within the on-time range, count as valid
            if (check)
                answer++;
        }
        return answer;
    }
}

