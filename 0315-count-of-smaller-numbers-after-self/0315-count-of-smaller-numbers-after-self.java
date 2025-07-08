class Solution {
    public List<Integer> countSmaller(int[] nums) {

        int[] indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        int[] result = new int[nums.length];
        
        mergeSort(nums, indexes, result, 0, nums.length - 1);

        return arrayToList(result);
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int n : array) {
            list.add(n);
        }
        return list;
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
        int k = 0;
        int i = left;
        int j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                rightCount++;
                temp[k++] = indexes[j++];
            } else {
                result[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            result[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p];
        }
    }
}