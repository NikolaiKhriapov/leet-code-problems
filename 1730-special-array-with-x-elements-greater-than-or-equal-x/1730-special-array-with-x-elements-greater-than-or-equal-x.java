class Solution {
    public int specialArray(int[] nums) {
        int[] arr = new int[nums.length + 1];
        
        for (int n : nums) {
            if (n >= arr.length - 1) {
                arr[arr.length - 1]++;
            } else {
                arr[n]++;
            }
        }
        
        int sum = 0;
        for (int i = arr.length - 1; i >= 0;i --) {
            sum += arr[i];
            if (sum == i) return i;
        }

        return -1;
    }
}