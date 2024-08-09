class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int possible = 0;
        int l = 0;
        int r = 0;
        
        while (r < flowerbed.length) {
            if (flowerbed[r] == 0) {
                r++;
            } else {
                int currLength = r - l;
                if (l == 0 && currLength > 1) {
                    possible += currLength / 2;
                } else if (currLength > 2) {
                    possible += (currLength - 1) / 2;
                }
                r++;
                l = r;
            }
        }
        
        if (l == 0 && r == flowerbed.length) {
            possible = (r - l + 1) / 2;
        } else {
            possible += (r - l) / 2;
        }

        return possible >= n;
    }
}