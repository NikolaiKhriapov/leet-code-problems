class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];

        if (k == 0) {
            return arr;
        }

        int sum = 0;
        
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
        } else {
            for (int i = -1; i >= k; i--) {
                sum += code[(code.length + i) % code.length]; 
            }
        }
        arr[0] = sum;

        for (int i = 1; i < code.length; i++) {
            if (k > 0) {
                sum -= code[i % code.length];
                sum += code[(i + k) % code.length];
            } else {
                sum -= code[(code.length + i + k - 1) % code.length];
                sum += code[(i - 1) % code.length];
            }
            arr[i] = sum;
        }

        return arr;
    }
}