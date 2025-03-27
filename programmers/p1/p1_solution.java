class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int len_t = convertTime(video_len);
        int pos_t = convertTime(pos);
        int op_s_t = convertTime(op_start);
        int op_e_t = convertTime(op_end);       
        
        int now = pos_t;
        
        for (String comm : commands) {
            
            now = checkOpening(op_s_t, op_e_t, now);
            
            if (comm.equals("next")) {      // if "next", go to 10 sec later
                if (now <= len_t-10)
                    now += 10;
                else                                // video_len if now remains less than 10 esc
                    now = len_t;            
            } else if (comm.equals("prev")){  // if "prev", go to 10 sec before
                if (now > 10)
                    now -= 10;
                else                                // 0 if now remains less than 10 sec
                    now = 0;
            }            
        }
        now = checkOpening(op_s_t, op_e_t, now);
        
        int hour = now / 60;
        int min = now % 60;
        
        answer = String.format("%02d:%02d", hour, min);
        return answer;
    }
    
    // Check if position is beetween op_start and op_end
    public int checkOpening(int op_s_t, int op_e_t, int now){
             
        if (now >= op_s_t && now <= op_e_t) 
            now = op_e_t;
        
        return now;
    }
    
    // Convert time : String to Integer
    public int convertTime(String time_st){
        int time_int = 0;
        
        int hour = Integer.parseInt(time_st.substring(0,2));
        int min = Integer.parseInt(time_st.substring(3,5));
        time_int = hour*60+min;
        
        return time_int;
    }
}