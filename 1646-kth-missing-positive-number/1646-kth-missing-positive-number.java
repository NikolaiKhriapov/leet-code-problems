class Solution {
    public int findKthPositive(int[] arr, int k) {

        int curr = 1;
        int idx = 0;

        while (k > 0) {
            if (idx < arr.length && arr[idx] == curr) {
                idx++;
            } else {
                k--;
            }
            curr++;
        }

        return curr - 1;
    }
}