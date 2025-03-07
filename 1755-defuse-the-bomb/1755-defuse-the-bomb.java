class Solution {
    public int[] decrypt(int[] code, int k) {
        int l = code.length;
        int[] result = new int[l];

        if (k == 0) return result;

        int temp = k;

        int init = 0;
        int p = k > 0 ? 1 : -1;
        while (temp > 0) {
            if (p == l) p = 0;
            init += code[p];
            p++;
            temp--;
        }
        while (temp < 0) {
            if (p == -1) p = l - 1;
            init += code[p];
            p--;
            temp++;
        }

        result[0] = init;

        if (k > 0) {
            for (int i = 1; i < l; i++) {
                p %= l;
                result[i] = result[i - 1] - code[i] + code[p];
                p++;
            }
        } else {
            for (int i = l - 1; i >= 0; i--) {
                if (p < 0) p += l;
                result[i] = result[(i + 1) % l] - code[i] + code[p];
                p--;
            }
        }
        
        return result;
    }
}