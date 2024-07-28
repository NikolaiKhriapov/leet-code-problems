import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        int length = s.length();
        if (length <= 1) return "";

        String longestNice = "";

        for (int l = 0; l < length; l++) {
            Set<Character> lowerSet = new HashSet<>();
            Set<Character> upperSet = new HashSet<>();

            for (int r = l; r < length; r++) {
                char c = s.charAt(r);
                if (Character.isLowerCase(c)) {
                    lowerSet.add(c);
                } else {
                    upperSet.add(c);
                }

                if (isNice(lowerSet, upperSet)) {
                    int currentLength = r - l + 1;
                    if (currentLength > longestNice.length()) {
                        longestNice = s.substring(l, r + 1);
                    }
                }
            }
        }

        return longestNice;
    }

    private boolean isNice(Set<Character> lowerSet, Set<Character> upperSet) {
        for (char c : lowerSet) {
            if (!upperSet.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        for (char c : upperSet) {
            if (!lowerSet.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }
}
