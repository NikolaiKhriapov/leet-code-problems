class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;

        for (int n : arr1) {
            boolean isGood = true;
            for (int m : arr2) {
                if (Math.abs(n - m) <= d) isGood = false;
            }
            if (isGood) count++;
        }

        return count;
    }
}