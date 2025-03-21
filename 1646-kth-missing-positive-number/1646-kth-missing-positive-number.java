class Solution {
    public int findKthPositive(int[] arr, int k) {
        return k + helper(arr, k, 0, arr.length - 1);
    }

    private int helper(int[] arr, int k, int l, int r) {
        if (l > r) return l;

        int m = l + (r - l) / 2;

        if (arr[m] - m - 1 < k) return helper(arr, k, m + 1, r);
        return helper(arr, k, l, m - 1);
    }
}
