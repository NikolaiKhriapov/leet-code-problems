class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]).append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}

// time  - O(n)
// space - O(n)
