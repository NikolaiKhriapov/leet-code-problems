class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();

        if (sArr.length < 2) {
            return sArr.length;
        }

        int lengthMax = 0;
        int l = 0;
        int r = 0;
        
        Set<Character> currChars = new HashSet<>();
        while (l < sArr.length && r < sArr.length) {
            boolean isAdded = currChars.add(sArr[r]);
            if (isAdded) {
                lengthMax = Math.max(lengthMax, r - l + 1);
            } else {
                while (l < sArr.length && sArr[l] != sArr[r]) {
                    currChars.remove(sArr[l]);
                    l++;
                }
                l++;
            }
            r++;
        }

        return lengthMax;
    }
}