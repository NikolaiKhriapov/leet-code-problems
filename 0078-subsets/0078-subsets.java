class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            generateNewSubsets(nums, i, result);
        }

        return result;
    }

    private void generateNewSubsets(int[] nums, int idx, List<List<Integer>> result) {
        List<List<Integer>> newLists = new ArrayList<>();
        for (List<Integer> list : result) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[idx]);
            newLists.add(newList);
        }
        result.addAll(newLists);
    }
}