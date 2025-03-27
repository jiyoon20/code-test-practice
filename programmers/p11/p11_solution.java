class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // Step 1: Convert to lowercase
        new_id = new_id.toLowerCase();
        
        // Step 2: Remove all characters except lowercase letters, digits, '-', '_', and '.'
        new_id = new_id.replaceAll("[^a-z0-9\\-_\\.]", "");
        
        // Step 3: Replace multiple consecutive dots with a single dot
        new_id = new_id.replaceAll("\\.+", ".");
        
        // Step 4: Remove leading and trailing dots
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");        
        
        // Step 5: If the string is empty, assign "a"
        if (new_id.isEmpty())
            new_id = "a";
        
        // Step 6: If the length is greater than or equal to 16, trim to 15 characters
        if (new_id.length() >= 16)
            new_id = new_id.substring(0, 15);
        
        // Remove trailing dot again if present after trimming
        new_id = new_id.replaceAll("\\.$", "");
        
        // Step 7: If the length is 2 or less, repeat the last character until the length becomes 3
        if (new_id.length() <= 2) {
            int count = 3 - new_id.length();
            String str = String.valueOf(new_id.charAt(new_id.length() - 1));
            new_id = new_id + str.repeat(count);
        }

        answer = new_id;
        
        return answer;
    }
}
