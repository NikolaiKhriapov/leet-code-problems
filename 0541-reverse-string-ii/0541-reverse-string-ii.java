class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int sl = sArr.length;

        int l = 0;
        
        while (l < sl) {
            int r = (l + k <= sl) ? (l + k) : sl;
            
            sArr = helper(sArr, l, r - 1);

            l += k * 2;
        }

        return new String(sArr);
    }

    private char[] helper(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}