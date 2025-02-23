class Solution {
    public int specialArray(int[] nums) {
        int[] arr = new int[nums.length + 1];

        for (int n : nums) {
            for (int i = 0; i < arr.length; i++) {
                if (n >= i) arr[i]++;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (i == arr[i]) return i;
        }

        return -1;
    }
}