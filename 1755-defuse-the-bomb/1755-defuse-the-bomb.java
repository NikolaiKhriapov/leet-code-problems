class Solution {
    public int[] decrypt(int[] code, int k) {
        int cl = code.length;
        int[] result = new int[cl];

        if (k == 0) return result;

        int sum = 0;
        int start;
        int end;

        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = cl + k;
            end = cl - 1;
        }

        for (int i = start; i <= end; i++) {
            sum += code[i % cl];
        }

        for (int i = 0; i < cl; i++) {
            result[i] = sum;
            sum -= code[start++ % cl];
            sum += code[++end % cl];
        }

        return result;
    }
}