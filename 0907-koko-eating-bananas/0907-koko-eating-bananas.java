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
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;        
    }

    private int getMaxPile(int[] piles) {
        int result = 0;
        for (int pile : piles) {
            result = Math.max(result, pile);
        }
        return result;
    }

    private int countHours(int[] piles, int k) {
        int result = 0;
        for (int pile : piles) {
            result += (pile / k) + (pile % k == 0 ? 0 : 1);
        }
        return result;
    }
}

// [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,[16,17,18,19,[20,21,[22,[23],24,25,26,27,28,29,30]