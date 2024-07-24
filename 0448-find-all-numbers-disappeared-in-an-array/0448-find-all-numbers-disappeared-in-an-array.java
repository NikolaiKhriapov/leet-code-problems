class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] array = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            array[nums[i] - 1] = 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) result.add(i + 1);
        }
        
        return result;
    }
}