class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            boolean prevIsZero = i == 0 || flowerbed[i - 1] == 0;
            boolean nextIsZero = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (flowerbed[i] == 0 && prevIsZero && nextIsZero) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return n == 0;
    }
}

// time. - O(n)
// space - O(1)