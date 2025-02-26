class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];

        if (k == 0) return arr;

        int sum = 0;
        
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            arr[0] = sum;

            for (int i = 1; i < arr.length; i++) {
                int l = i;
                int r = i + k;
                if (l >= code.length) l -= code.length;
                if (r >= code.length) r -= code.length;
                
                sum += code[r] - code[l];
                arr[i] = sum;
            }
        }
        
        if (k < 0) {
            for (int i = code.length - 1; i >= code.length + k; i--) {
                sum += code[i];
            }
            arr[0] = sum;

            for (int i = arr.length - 1; i >= 0; i--) {
                int l = i;
                int r = i + k;
                if (l < 0) l += code.length;
                if (r < 0) r += code.length;
                
                sum += code[r] - code[l];
                arr[i] = sum;
            }
        }

        return arr;
    }
}