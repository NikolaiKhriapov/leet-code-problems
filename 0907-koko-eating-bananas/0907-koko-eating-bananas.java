class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || h < piles.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 1;
        int right = getMaxPile(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = countHours(piles, mid);
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    private int countHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / k + 1;
        }
        return hours;
    }
}