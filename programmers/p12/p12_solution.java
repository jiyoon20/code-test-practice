import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();

        // Initialize personality type scores
        map.put('A', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('N', 0);
        map.put('M', 0);
        map.put('R', 0);
        map.put('T', 0);

        // Process survey responses
        for (int i = 0; i < survey.length; i++) {
            char[] ch = survey[i].toCharArray();
            addMap(ch, choices[i], map);
        }

        // Determine final personality type based on scores
        answer += (map.get('R') >= map.get('T')) ? 'R' : 'T';
        answer += (map.get('C') >= map.get('F')) ? 'C' : 'F';
        answer += (map.get('J') >= map.get('M')) ? 'J' : 'M';
        answer += (map.get('A') >= map.get('N')) ? 'A' : 'N';

        return answer;
    }

    /**
     * Updates the personality type score based on the choice value.
     * Lower values (1-3) increase the score for the first character,
     * higher values (5-7) increase the score for the second character.
     * Choice 4 has no effect.
     */
    public void addMap(char[] ch, int choice, Map<Character, Integer> map) {
        if (choice == 1)
            map.put(ch[0], map.get(ch[0]) + 3);
        else if (choice == 2)
            map.put(ch[0], map.get(ch[0]) + 2);
        else if (choice == 3)
            map.put(ch[0], map.get(ch[0]) + 1);
        else if (choice == 5)
            map.put(ch[1], map.get(ch[1]) + 1);
        else if (choice == 6)
            map.put(ch[1], map.get(ch[1]) + 2);
        else if (choice == 7)
            map.put(ch[1], map.get(ch[1]) + 3);
    }
}
