class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown-4) / 2;  // Calculate the sum of width and height minus 2
        int x = 0, y = 0;
        
        // Find the dimensions of the yellow rectangle
        for (int i = 1; i < sum; i++) {
            for (int j = 1; j < sum; j++) {
                if (i * j == yellow && i + j == sum) {  // Check if the area and perimeter match
                    x = i;
                    y = j;
                    break;
                }
            }            
        }
        
        // Assign larger value to x and smaller to y
        x = Math.max(x, y);
        y = Math.min(x, y);
        
        // Add 2 to account for the brown border
        answer[0] = x + 2;
        answer[1] = y + 2;
        
        return answer;  // Return the result
    }
}
