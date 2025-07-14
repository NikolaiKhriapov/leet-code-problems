class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || h < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 1;
        int right = getMaxPileSize(piles);
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

    private int getMaxPileSize(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    private int countHours(int[] piles, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile / mid) + (pile % mid == 0 ? 0 : 1);
        }
        return hours;
    }
}