class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();

        if (sArr.length < 2) {
            return sArr.length;
        }

        int lengthMax = 0;
        int left = 0;
        int right = 0;
        
        Set<Character> currChars = new HashSet<>();
        while (left < sArr.length && right < sArr.length) {
            boolean isAdded = currChars.add(sArr[right]);
            if (isAdded) {
                lengthMax = Math.max(lengthMax, right - left + 1);
            } else {
                while (left < sArr.length && sArr[left] != sArr[right]) {
                    currChars.remove(sArr[left]);
                    left++;
                }
                left++;
            }
            right++;
        }

        return lengthMax;
    }
}