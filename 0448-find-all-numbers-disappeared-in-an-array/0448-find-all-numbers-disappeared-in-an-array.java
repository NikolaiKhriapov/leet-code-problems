class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        boolean[] array = new boolean[nums.length + 1];
        for (int n : nums) {
            array[n] = true;
        }

        for (int i = 1; i < array.length; i++) {
            if (!array[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}