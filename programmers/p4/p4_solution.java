class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        // Iterate through the park grid to find empty spaces ("-1")
        for(int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if ("-1".equals(park[i][j])) { // If the current cell is empty
                    // Try placing the largest mat first
                    for (int k = mats.length - 1; k >= 0; k--) {
                        if(checkArea(i, j, mats[k], park)) { // Check if the mat fits
                            answer = Math.max(answer, mats[k]); // Update the maximum mat size
                        }
                    }
                }
            }
        }
        return answer;
    }
        
    public boolean checkArea(int x, int y, int mat, String[][] park) {
        // Check if the mat exceeds the boundaries of the park
        if(x + mat > park.length)
            return false;
        
        for (int i = x; i < x + mat; i++) {
            if(y + mat > park[0].length) return false; // Ensure mat doesn't exceed width
            
            for(int j = y; j < y + mat; j++) {
                if(!"-1".equals(park[i][j])) // If any cell is occupied, the mat can't be placed
                    return false;
            }
        }
        return true; // Mat can be placed successfully
    }
}