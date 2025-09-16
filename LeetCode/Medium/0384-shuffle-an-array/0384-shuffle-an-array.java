class Solution {
    private int[] array;
    private int[] arrayOriginal;
    private static final Random RANDOMIZER = new Random();

    public Solution(int[] nums) {
        arrayOriginal = Arrays.copyOf(nums, nums.length);
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    }
    
    public int[] reset() {
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        return array;
    }
    
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int newIndex = RANDOMIZER.nextInt(i + 1);
            swap(array, i, newIndex);
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


 // time  - O(n)
 // space - O(n)