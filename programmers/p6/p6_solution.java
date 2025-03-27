class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int len = attacks.length; // Number of attacks
        int last = attacks[len - 1][0]; // Time of the last attack
        int top = health; // Maximum health
        
        int index = 0; // Index to track the current attack
        int count = 0; // Counter for continuous healing
        
        // Loop through each second from 1 to the last attack time
        for (int i = 1; i <= last; i++) {
            if (attacks[index][0] != i) { // If there is no attack at this time
                health = Math.min(health + bandage[1], top); // Heal by bandage amount but not exceeding max health
                
                count++; // Increase continuous healing count
                
                // If continuous healing reaches the required time, apply extra reward
                if (count >= bandage[0]) {
                    health = Math.min(health + bandage[2], top);
                    count = 0; // Reset count after bonus healing
                }
            } else { // If an attack occurs at this time
                health -= attacks[index][1]; // Reduce health by attack damage
                if (health <= 0) return -1; // If health drops to 0 or below, return -1 (defeat)
                    
                if (index < len - 1) index++; // Move to the next attack
                count = 0; // Reset healing counter since an attack interrupts healing
            }                         
        }
        
        // If health is still above 0 after all attacks, return remaining health
        if (health <= 0)
            answer = -1;
        else 
            answer = health;
        
        return answer;
    }
}