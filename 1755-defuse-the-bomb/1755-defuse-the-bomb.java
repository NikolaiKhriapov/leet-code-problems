class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        if (k == 0) return result;

        int start;
        int end;
        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = code.length + k;
            end = code.length - 1;
        }
        
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[start++ % code.length];
            sum += code[++end % code.length];
        }

        return result;
    }
}