import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;        
        int len = board.length; // Board size
        
        // Create an array of stacks to store columns of the board
        Stack<Integer>[] yStack = new Stack[len];
        for(int i = 0; i < len; i++){
            yStack[i] = new Stack<>();
        }
       
        // Populate stacks with values from the board, top to bottom
        for(int i = 0; i < len; i++) {
            for(int j = len - 1; j >= 0; j--){
                if(board[j][i] != 0) // If the slot is not empty, add it to the stack
                    yStack[i].push(board[j][i]);
            }
        }
        
        Stack<Integer> game = new Stack<>(); // Stack to simulate picking up toys
        for(int i = 0; i < moves.length; i++){
            int y_pos = moves[i] - 1; // Convert move to 0-based index
            
            // If the stack is not empty, pick the top toy
            if (!yStack[y_pos].isEmpty())
                game.push(yStack[y_pos].pop());
            
            // If the last two toys are the same, remove them and increase the score
            if(game.size() >= 2 && 
               game.get(game.size() - 1) == game.get(game.size() - 2)) {
                game.pop();
                game.pop();
                answer += 2;
            }
        }
        return answer; // Return the total number of removed toys
    }
}
