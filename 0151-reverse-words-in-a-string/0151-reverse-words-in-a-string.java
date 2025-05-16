class Solution {
    public String reverseWords(String s) {
        
        String[] parts = s.split(" ");
        for (int i = 0; i < parts.length / 2; i++) {
            String temp = parts[i];
            parts[i] = parts[parts.length - 1 - i];
            parts[parts.length - 1 - i] = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                result.append(parts[i]).append(" ");
            }
        }

        return result.toString().trim();
    }
}