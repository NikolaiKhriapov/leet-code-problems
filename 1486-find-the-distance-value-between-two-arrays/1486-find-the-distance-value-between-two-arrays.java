class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        Arrays.sort(arr2);
        for (int n : arr1) {
            boolean isAllHigher = search(arr2, n, d, 0, arr2.length - 1);
            if (isAllHigher) {
                count++;
            }
        }

        return count;
    }

    private boolean search(int[] arr2, int n, int d, int l, int r) {
        if (l > r) {
            return true;
        }

        int m = l + (r - l) / 2;
        
        if (Math.abs(n - arr2[m]) <= d) {
            return false;
        } else if (arr2[m] < n) {
            return search(arr2, n, d, m + 1, r);
        } else {
            return search(arr2, n, d, l, m - 1);
        }
    }
}