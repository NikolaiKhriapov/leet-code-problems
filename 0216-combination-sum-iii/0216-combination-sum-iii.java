class Solution {
    private static final int LOWEST = 1;
    private static final int HIGHEST = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < LOWEST || k > HIGHEST) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<Integer>> result = new ArrayList<>();
        helper(k, LOWEST, n, new ArrayList<>(), result);
        return result;
    }

    private void helper(int size, int start, int target, List<Integer> curr, List<List<Integer>> result) {
        if (target < 0 || curr.size() > size) {
            return;
        }
        if (target == 0) {
            if (curr.size() == size) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = start; i <= HIGHEST; i++) {
            curr.add(i);
            helper(size, i + 1, target - i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

// time  - O()
// space - O(k)