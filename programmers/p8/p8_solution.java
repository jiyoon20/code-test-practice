class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // Iterate through each scheduled work time
        for(int i = 0; i < schedules.length; i++){
            int sc = schedules[i]; // Scheduled work time in HHMM format
            
            int ontime = sc + 10; // Define on-time threshold (10 minutes after schedule)
            
            // Adjust ontime if minutes exceed 59 (convert to proper hour format)
            if ((ontime % 100) > 59) {
                int hour = ontime / 100;
                int minute = ontime % 100;
                
                ontime = (hour + 1) * 100 + (minute - 60);
            }
            
            boolean check = true;
            // Check attendance logs for each day
            for (int j = 0; j < timelogs[i].length; j++) {
                int week = (startday + j) % 7; // Determine the day of the week
                
                if (week != 6 && week != 0) { // Exclude weekends (Saturday=6, Sunday=0)
                    if (ontime < timelogs[i][j]) { // If logged time is later than on-time threshold
                        check = false;
                    }
                }                    
            }
            
            // If employee was on time for all working days, count as valid
            if (check)
                answer++;
        }
        return answer;
    }
}