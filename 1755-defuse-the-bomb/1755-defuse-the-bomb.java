class Solution {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;

        int[] arr = new int[length];

        if (k > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j <= k; j++) {
                    int idx = i + j;
                    if (idx >= length) idx -= length;
                    arr[i] += code[idx];
                }
            }
        }

        if (k < 0) {
            for (int i = 0; i < length; i++) {
                for (int j = 1, kk = k * -1; j <= kk; j++) {
                    int idx = i - j;
                    if (idx < 0) idx += length;
                    arr[i] += code[idx];
                }
            }
        }

        return arr;
    }
}