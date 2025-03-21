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
            if (k > 0) {
                sum -= code[(i + 1) % code.length];
                sum += code[(i + 1 + k) % code.length];
            } else {
                sum -= code[(i + code.length + k) % code.length];
                sum += code[i];
            }
        }

        return result;
    }
}