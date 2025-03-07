class Solution {
    public int[] decrypt(int[] code, int k) {
        int l = code.length;
        int[] result = new int[l];

        if (k == 0) return result;

        int sum = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
        }
        if (k < 0) {
            for (int i = -1; i >= k; i--) {
                sum += code[i + l];
            }
        }
        result[0] = sum;

        for (int i = 1; i < l; i++) {
            if (k > 0) {
                sum -= code[i];
                sum += code[(i + k) % l];
            } else {
                sum -= code[(i + k - 1 + l) % l];
                sum += code[i - 1];
            }
            result[i] = sum;
        }

        return result;
    }
}