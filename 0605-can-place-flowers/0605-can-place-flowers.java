class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 0) {
            return true;
        }
        
        for (int i = 0; i < flowerbed.length; i++) {
            boolean isLeftZero = i == 0 || flowerbed[i - 1] == 0;
            boolean isRightZero = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (flowerbed[i] == 0 && isLeftZero && isRightZero) {
                flowerbed[i] = 1;
                if (--n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

// time  - O(n)
// space - O(1)