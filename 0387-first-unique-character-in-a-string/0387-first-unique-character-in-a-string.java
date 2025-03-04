class Solution {
    public int firstUniqChar(String s) {
        char[] sArr = s.toCharArray();
        int[] count = new int[26];

        for (char c : sArr) {
            count[c - 'a']++;
        }

        for (int i = 0; i < sArr.length; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}