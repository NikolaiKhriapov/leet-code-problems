class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        Integer[] array = set.toArray(new Integer[0]);

        Arrays.sort(array);

        if (array.length > 2) {
            return array[array.length - 3];
        } else {
            return array[array.length - 1];
        }
    }
}