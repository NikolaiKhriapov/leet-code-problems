class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        int[] result = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, result, 0, nums.length - 1);
        return arrayToList(result);
    }

    private void mergeSort(int[] nums, int[] indexes, int[] result, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, indexes, result, left, mid);
        mergeSort(nums, indexes, result, mid + 1, right);
        
        merge(nums, indexes, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indexes, int[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int t = 0;
        int l = left;
        int r = mid + 1;
        int rightCount = 0;

        while (l <= mid && r <= right) {
            if (nums[indexes[r]] < nums[indexes[l]]) {
                rightCount++;
                temp[t++] = indexes[r++];
            } else {
                result[indexes[l]] += rightCount;
                temp[t++] = indexes[l++];
            }
        }
        while (l <= mid) {
            result[indexes[l]] += rightCount;
            temp[t++] = indexes[l++];
        }
        while (r <= right) {
            temp[t++] = indexes[r++];
        }

        for (int i = 0; i < temp.length; i++) {
            indexes[left + i] = temp[i];
        }
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int n : array) {
            result.add(n);
        }
        return result;
    }
}