class Solution {
    public int minEatingSpeed(int[] piles, int h) {

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
        int result = 0;
        for (int pile : piles) {
            result = Math.max(result, pile);
        }
        return result;
    }

    private int countHours(int[] piles, int k) {
        int result = 0;
        for (int pile : piles) {
            result += (pile - 1) / k + 1;
        }
        return result;
    }
}

// [1,2,3,4,5,6,7,8,9,10,11]