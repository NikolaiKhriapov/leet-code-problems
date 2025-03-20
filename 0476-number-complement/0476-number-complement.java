class Solution {
    public int findComplement(int num) {
        int mask = 1;

        int temp = num;
        int h = -1;
        for (int i = 0; i < 32; i++) {
            if (temp % 2 == 1) h = i;
            temp >>= 1;
        }

        for (int i = 0; i < h; i++) {
            mask <<= 1;
            mask += 1;
        }

        return mask - num;
    }
}