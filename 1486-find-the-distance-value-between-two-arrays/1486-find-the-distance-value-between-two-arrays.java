class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int counter = 0;

        Arrays.sort(arr2);

        for (int n : arr1) {
            if (helper(arr2, n, d, 0, arr2.length - 1)) {
                counter++;
            }
        }

        return counter;        
    }

    private boolean helper(int[] arr, int n, int d, int l, int r) {
        if (l > r) return false;

        int m = l + (r - l) / 2;

        if (arr[m] == n) return false;
        if (arr[m] < n) {
            if (m == arr.length - 1) return Math.abs(n - arr[m]) > d;
            if (arr[m + 1] > n) return Math.abs(n - arr[m]) > d && Math.abs(n - arr[m + 1]) > d;
            return helper(arr, n, d, m + 1, r);
        }
        if (m == 0) return Math.abs(n - arr[m]) > d;
        if (arr[m - 1] < n) return Math.abs(n - arr[m]) > d && Math.abs(n - arr[m - 1]) > d;
        return helper(arr, n, d, l, m - 1);
    }
}