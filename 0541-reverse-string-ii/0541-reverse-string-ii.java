class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i += 2 * k) {
            int r = (i + k > sArr.length) ? sArr.length : (i + k);
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