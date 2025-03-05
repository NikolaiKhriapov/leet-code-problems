class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int result = 0;
        for (int n : arr1) {
            if (helper(arr2, n, d, 0, arr2.length - 1)) {
                result++;
            }
        }

        return result;
    }

    private boolean helper(int[] arr, int n, int d, int l, int r) {
        if (l > r) return true;

        int m = l + (r - l) / 2;

        if (arr[m] > n + d) return helper(arr, n, d, l, m - 1);
        if (arr[m] < n - d) return helper(arr, n, d, m + 1, r);

        return false;
    }
}