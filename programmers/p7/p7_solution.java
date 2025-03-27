class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int height = park.length;
        int width = park[0].length();
        
        char[][] parkArea = new char[height][width];  
        
        // Convert the park layout from string array to character matrix
        for (int i = 0; i < height; i++) {
            parkArea[i] = park[i].toCharArray();
        }
        
        int x = 0, y = 0;
        
        // Find the starting position ('S')
        for (int i = 0; i < parkArea.length; i++) {
            for (int j = 0; j < parkArea[i].length; j++) {
                if (parkArea[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        // Process each movement command
        for (int j = 0; j < routes.length; j++) {
            char[] order = routes[j].replace(" ", "").toCharArray(); // Remove spaces and convert to character array
            int move = order[1] - '0'; // Convert movement distance to integer
                       
            if (order[0] == 'E') {  // Move east
                if (checkMove(x, y, 0, move, parkArea)) {
                    y = y + move;  
                }
            } else if (order[0] == 'W') {  // Move west
                if (checkMove(x, y, 0, -move, parkArea)) {
                    y = y - move;  
                }
            } else if (order[0] == 'S') { // Move south
                if (checkMove(x, y, 1, move, parkArea)) {
                    x = x + move;  
                }
            } else if (order[0] == 'N') {  // Move north
                if (checkMove(x, y, 1, -move, parkArea)) {
                    x = x - move;  
                }
            }
        }
        
        // Store final position in the answer array
        answer[0] = x;  
        answer[1] = y;
        return answer;
    }
    

    /**
     * Checks if a movement is valid by ensuring it stays within bounds
     * and does not pass through obstacles ('X').
     * @param x        Current row position
     * @param y        Current column position
     * @param direction 0 for horizontal movement, 1 for vertical movement
     * @param move     Distance to move
     * @param parkArea Park layout matrix
     * @return true if the move is valid, false otherwise
     */
    public boolean checkMove(int x, int y, int direction, int move, char[][] parkArea) {
        int height = parkArea.length; 
        int width = parkArea[0].length;  
        
        if (direction == 0) {  // Horizontal movement
            if (y + move < 0 || y + move >= width) { // Check boundary limits
                return false;
            }
            
            int start = Math.min(y, y + move); 
            int end = Math.max(y, y + move);
            
            // Check for obstacles in the path
            for (int i = start; i <= end; i++) {
                if (parkArea[x][i] == 'X') {
                    return false;
                }
            }
        } else { // Vertical movement
            if (x + move < 0 || x + move >= height) { // Check boundary limits
                return false;
            }
            
            int start = Math.min(x, x + move); 
            int end = Math.max(x, x + move); 
            
            // Check for obstacles in the path
            for (int i = start; i <= end; i++) {
                if (parkArea[i][y] == 'X') {
                    return false;
                }
            }
        }
        
        return true; // Movement is valid
    }
}
