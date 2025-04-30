class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int largest = list.get(list.size() - 1);
            if (n > largest) {
                list.add(n);
            } else {
                int position = findPosition(list, n, 0, list.size() - 1);
                list.set(position, n);
            }
        }
        
        return list.size();
    }

    private int findPosition(List<Integer> list, int target, int l, int r) {
        if (l > r) return l; //TODO

        int m = l + (r - l) / 2;

        if (target == list.get(m)) return m;
        if (target < list.get(m)) {
            if (m == 0 || target > list.get(m - 1)) return m;
            else return findPosition(list, target, l, m - 1);
        }
        return findPosition(list, target, m + 1, r);
    }
}
