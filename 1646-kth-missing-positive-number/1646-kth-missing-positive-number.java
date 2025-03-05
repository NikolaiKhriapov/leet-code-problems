class Solution {
    public int findKthPositive(int[] arr, int k) {

        int idx = helper(arr, k, 0, arr.length - 1);
        
        return k + idx + 1;
    }

    private int helper(int[] arr, int k, int l, int r) {
        if (l > r) return r;

        int m = l + (r - l) / 2;

        int diff = arr[m] - (m + 1);
        if (diff >= k) return helper(arr, k, l, m - 1);
        
        if (m == arr.length - 1 || (arr[m + 1] - (m + 2) > k)) return m;

        return helper(arr, k, m + 1, r);
    }
}