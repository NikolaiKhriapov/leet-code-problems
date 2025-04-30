class Solution {
    private int[] array;
    private int[] originalArray;
    private static final Random random = new Random();

    public Solution(int[] nums) {
        array = new int[nums.length];
        originalArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            originalArray[i] = nums[i];
        }
    }
    
    public int[] reset() {
        for (int i = 0; i < array.length; i++) {
            array[i] = originalArray[i];
        }
        return array;
    }
    
    public int[] shuffle() {
        shuffleArray(array);
        return array;
    }

    private static void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, random.nextInt(i + 1));
        }
    }

    private static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */