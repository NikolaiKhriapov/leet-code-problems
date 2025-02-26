class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            arr[i] = helper(code, k, i);
        }
        return arr;
    }

    private int helper(int[] code, int k, int idx) {
        int sum = 0;
        
        while (k > 0) {
            if (++idx == code.length) {
                idx = 0;
            }
            sum += code[idx];
            if (--k == 0) {
                break;
            }
        }
        
        while (k < 0) {
            if (--idx == -1) {
                idx = code.length - 1;
            }
            sum += code[idx];
            if (++k == 0) {
                break;
            }
        }

        return sum;
    }
}