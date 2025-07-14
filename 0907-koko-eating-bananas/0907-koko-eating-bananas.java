class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

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

    private int countHours(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k + (pile % k == 0 ? 0 : 1);
        }
        return hours;
    }
}