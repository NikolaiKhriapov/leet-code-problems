class Solution {
    public String reverseStr(String s, int k) {
        int sl = s.length();

        int l = 0;
        
        while (l < sl) {
            int r = (l + k <= sl) ? (l + k) : sl;
            
            s = helper(s, l, r - 1);

            l += k * 2;
        }

        return s;
    }

    private String helper(String s, int l, int r) {
        char[] sArr = s.toCharArray();

        while (l < r) {
            char temp = sArr[l];
            sArr[l] = sArr[r];
            sArr[r] = temp;
            l++;
            r--;
        }

        return new String(sArr);
    }
}