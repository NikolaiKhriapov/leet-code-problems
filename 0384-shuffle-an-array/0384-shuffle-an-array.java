class Solution {
    private int[] array;
    private int[] arrayOriginal;
    private final static Random RANDOM = new Random();

    public Solution(int[] nums) {
        arrayOriginal = Arrays.copyOf(nums, nums.length);
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
    }
    
    public int[] reset() {
        array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        return array;
    }
    
    public int[] shuffle() {
        shuffle(array);
        return array;
    }

    private void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, RANDOM.nextInt(i + 1));
        }
    }

    private void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}

// [1,2,3,4,5]
// [-,-,-,-,-]