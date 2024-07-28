class Solution {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;

        int[] arr = new int[length];

        if (k > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = 1; j <= k; j++) {
                    int tmp = i + j;
                    if (tmp >= length) tmp -= length;
                    arr[i] += code[tmp];
                }
            }
        }

        if (k < 0) {
            for (int i = 0; i < length; i++) {
                for (int j = 1, kk = k * -1; j <= kk; j++) {
                    int tmp = i - j;
                    if (tmp < 0) tmp += length;
                    arr[i] += code[tmp];
                }
            }
        }

        return arr;
    }
}