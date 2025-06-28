class Solution {
    public int firstMissingPositive(int[] nums) {


        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                set.add(n);
            }
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(result)) {
                return result;
            }
            result++;
        }        

        return result;
    }
}