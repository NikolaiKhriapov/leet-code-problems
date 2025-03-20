class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        int resultFirst = 0;
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                resultFirst += code[i % code.length];
            }
        }
        if (k < 0) {
            for (int i = -1; i >= k; i--) {
                resultFirst += code[i + code.length];
            }
        }
        result[0] = resultFirst;

        if (k > 0) {
            for (int i = 1; i < result.length; i++) {
                result[i] = result[i - 1] - code[i] + code[(i + k) % code.length];
            }
        }
        if (k < 0) {
            for (int i = 1; i < result.length; i++) {
                result[i] = result[i - 1] - code[(i - 1 + code.length + k) % code.length] + code[i - 1];
            }
        }

        return result;
    }
}