class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }
        
        return sb.toString();
    }
}

// time  - O(n)
// space - O(n)
