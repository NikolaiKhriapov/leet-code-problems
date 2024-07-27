class Solution {
    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int p = 0;

        while (p < arr.length) {
            int r = p + k;
            r = r > arr.length ? arr.length : p + k;
            arr = reverse(arr, p, r - 1);
            p += 2 * k;
        }
        
        return new String(arr);
    }

    private char[] reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return arr;
    }
}