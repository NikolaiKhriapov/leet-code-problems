class Solution {
    public int[] decrypt(int[] code, int k) {
        if (code == null || k >= code.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int[] result = new int[code.length];

        if (k == 0) {
            return result;
        } else if (k > 0) {
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = sum;
                sum -= code[(i + 1) % code.length];
                sum += code[(i + 1 + k) % code.length];
            }
        } else {
            int sum = 0;
            for (int i = code.length - 1; i >= code.length + k; i--) {
                sum += code[i];
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = sum;
                sum += code[i];
                sum -= code[(i + code.length + k) % code.length];
            }
        }

        return result;
    }
}

// time  - O(n)
// space - O(n)