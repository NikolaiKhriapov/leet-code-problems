class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int n : nums) {
            numbers.add(n);
        }

        int maxCount = 0;
        for (int n : numbers) {
            if (numbers.contains(n - 1) || visited.contains(n)) {
                continue;
            }
            visited.add(n);

            int currNumber = n + 1;
            int count = 1;
            while (numbers.contains(currNumber++)) {
                count++;
                visited.add(currNumber);
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}