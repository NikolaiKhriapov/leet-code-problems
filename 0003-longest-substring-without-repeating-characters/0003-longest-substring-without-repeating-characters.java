class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();

        if (sArr.length < 2) {
            return sArr.length;
        }

        int lengthMax = 0;
        int l = 0;
        int r = 0;
        
        Set<Character> set = new HashSet<>();
        while (l < sArr.length && r < sArr.length) {
            boolean isAdded = set.add(sArr[r]);
            if (isAdded) {
                int lengthCurr = r - l + 1;
                lengthMax = Math.max(lengthMax, lengthCurr);
            } else {
                while (l < sArr.length && sArr[l] != sArr[r]) {
                    set.remove(sArr[l]);
                    l++;
                }
                l++;
            }
            r++;
        }

        return lengthMax;
    }
}