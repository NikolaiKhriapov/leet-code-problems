class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();

        int l = 0;
        
        while (l < sArr.length) {
            int r = (l + k <= sArr.length) ? (l + k) : sArr.length;
            
            helper(sArr, l, r - 1);

            l += k * 2;
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