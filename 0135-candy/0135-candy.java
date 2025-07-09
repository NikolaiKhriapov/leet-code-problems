class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i];
        }

        return count;
    }
}