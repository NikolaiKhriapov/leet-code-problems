class Solution {
    public boolean isAnagram(String s, String t) {

        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        for (char c : t.toCharArray()) {
            if (count[c] <= 0) {
                return false;
            }
            count[c]--;
        }

        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}