import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        // Calculate remaining days for each task to complete
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int release = (int) Math.ceil((double) remain / speeds[i]);
            queue.add(release);
        }
        
        // Count how many tasks can be released together
        while (!queue.isEmpty()) {
            int work = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && work >= queue.peek()) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        
        // Convert list to array
        return list.stream().mapToInt(i -> i).toArray();
    }
}
