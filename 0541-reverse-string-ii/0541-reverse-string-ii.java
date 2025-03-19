class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int sl = sArr.length;

        for (int i = 0; i < sl; i += 2 * k) {
            int r = Math.min(i + k, sl);
            helper(sArr, i, r - 1);
        }
        
        return new String(sArr);
    }

    private void helper(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}