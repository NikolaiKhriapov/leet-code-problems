class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = 0;
        int r = 0;

        int poss = 0;

        while (r < flowerbed.length) {
            if (flowerbed[r] == 0) {
                r++;
            } else {
                int currLength = r - l;
                if (l == 0 && currLength > 1) {
                    poss += currLength / 2;
                } else if (currLength > 2) {
                    poss += (currLength - 1) / 2;
                }
                r++;
                l = r;
            }
        }

        if (l == 0 && r == flowerbed.length) poss = ((r - l + 1) / 2);
        else poss += (r - l) / 2;

        return poss >= n;
    }
}