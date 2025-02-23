class Solution {
    public int findKthPositive(int[] arr, int k) {
        return k + helper(arr, k, 0, arr.length - 1);
    }

    private int helper(int[] arr, int k, int l, int r) {
        if (r < l) return l;

        int m = l + (r - l) / 2;
        int diff = arr[m] - m - 1;

        if (diff < k) return helper(arr, k, m + 1, r);
        return helper(arr, k, l, m - 1);
    }
}