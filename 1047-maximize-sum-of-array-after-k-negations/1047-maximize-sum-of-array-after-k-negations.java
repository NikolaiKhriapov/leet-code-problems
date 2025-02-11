class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                break;
            }

            if (nums[i] < 0) {
                nums[i] *= -1;
                k--;
            } else if (nums[i] == 0) {
                break;
            } else if (nums[i] > 0) {
                if (i == 0) {
                    while (k > 0) {
                        nums[i] *= -1;
                        k--;
                    }
                } else {
                    if (Math.abs(nums[i]) >= Math.abs(nums[i - 1])) {
                        while (k > 0) {
                            nums[i - 1] *= -1;
                            k--;
                        }
                    } else {
                        while (k > 0) {
                            nums[i] *= -1;
                            k--;
                        }
                    }
                }
            }

            if (i == nums.length - 1 && k > 0) {
                i--;
            }
        }

        return calculateSum(nums);
    }

    private int calculateSum(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result += n;
        }
        return result;
    }
}