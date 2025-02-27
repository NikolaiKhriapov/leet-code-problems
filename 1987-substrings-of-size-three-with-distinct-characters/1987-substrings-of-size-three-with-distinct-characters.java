class Solution {
    public int countGoodSubstrings(String s) {
        char[] sArr = s.toCharArray();

        if (sArr.length < 3) {
            return 0;
        }

        int count = 0;

        int l = 0;
        int r = sArr.length > 3 ? 3 : sArr.length;
        while (r <= sArr.length) {
            if (isGood(s.substring(l, r))) {
                count++;
            }
            l++;
            r++;
        }

        return count;
    }

    private boolean isGood(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}