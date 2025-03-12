class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;
        for (int n : arr1) {
            if (helper(arr2, d, n, 0, arr2.length - 1)) {
                count++;
            }
        }
        
        return count;
    }

    private boolean helper(int[] arr, int d, int n, int l, int r) {
        if (l > r) return true;

        int m = l + (r - l) / 2;
        int diff = Math.abs(arr[m] - n);

        if (diff <= d) return false;        
        
        if (arr[m] - d > n) return helper(arr, d, n, l, m - 1);
        return helper(arr, d, n, m + 1, r);
    }
}