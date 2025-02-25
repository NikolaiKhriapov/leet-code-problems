class Solution {
    public String reverseStr(String s, int k) {
        char[] sArr = s.toCharArray();
        int sl = s.length();

        for (int i = 0; i < sl; i += 2*k) {
            reverse(sArr, i, Math.min(i + k, sl));
        }

        return new String(sArr);
    }

    private void reverse(char[] arr, int l, int r) {
        r--;
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }
}