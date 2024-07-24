class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int[] arr = new int[nums.length];

        int pe = 0;
        int po = 1;

        for (int n : nums) {
            if (n % 2 == 0) {
                arr[pe] = n;
                pe += 2;
            } else {
                arr[po] = n;
                po += 2;
            }
        }
        
        return arr;
    }
}