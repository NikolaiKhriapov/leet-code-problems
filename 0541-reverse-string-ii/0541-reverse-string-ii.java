class Solution {
    public String reverseStr(String s, int k) {
        int sl = s.length();
        char[] sArr = s.toCharArray();

        for (int i = 0; i < sl; i += 2*k) {
            if (i + 2*k <= sl) {
                reverse(sArr, i, i + k);
            } else if (i + k >= sl) {
                reverse(sArr, i, sl - 1);
            } else {
                reverse(sArr, i, i + k);
            }
        }

        return new String(sArr);
    }

    private void reverse(char[] arr, int l, int r) {
        for (int i = 0; i < (r - l) / 2; i++) {
            char t = arr[l + i];
            arr[l + i] = arr[r - 1 - i];
            arr[r - 1 - i] = t;
        }
    }
}