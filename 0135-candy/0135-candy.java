class Solution {
    public int candy(int[] ratings) {
        if (ratings == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i - 1] + 1);
            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int count = 0;
        for (int n : candies) {
            count += n;
        }

        return count;
    }
}