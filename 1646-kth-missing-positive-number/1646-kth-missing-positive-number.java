class Solution {
    public int findKthPositive(int[] arr, int k) {

        int curr = 1;
        int index = 0;

        while (k > 0) {
            if (index < arr.length && arr[index] == curr) {
                index++;
            } else {
                k--;
            }
            curr++;
        }

        return curr - 1;
    }
}