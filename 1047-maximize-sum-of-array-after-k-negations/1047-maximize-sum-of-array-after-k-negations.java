class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter >= k) {
                break;
            }

            if (nums[i] < 0) {
                nums[i] *= -1;
                counter++;
            } else if (nums[i] == 0) {
                break;
            } else if (nums[i] > 0) {
                if (i == 0) {
                    while (counter < k) {
                        nums[i] *= -1;
                        counter++;
                    }
                } else {
                    if (Math.abs(nums[i]) >= Math.abs(nums[i - 1])) {
                        while (counter < k) {
                            nums[i - 1] *= -1;
                            counter++;
                        }
                    } else {
                        while (counter < k) {
                            nums[i] *= -1;
                            counter++;
                        }
                    }
                }
            }

            if (i == nums.length - 1 && counter < k) {
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