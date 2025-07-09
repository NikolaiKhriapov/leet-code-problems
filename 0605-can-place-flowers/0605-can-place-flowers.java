class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            boolean prevIsZero = i == 0 || flowerbed[i - 1] == 0;
            boolean nextIsZero = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (flowerbed[i] == 0 && prevIsZero && nextIsZero) {
                n--;
                i++;
            }
        }
        return n == 0;
    }
}