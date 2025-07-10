class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || extraCandies < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (candies.length == 0) {
            return new ArrayList<>();
        }

        int maxCandies = 0;
        for (int n : candies) {
            maxCandies = Math.max(maxCandies, n);
        }

        List<Boolean> result = new ArrayList<>();
        for (int n : candies) {
            result.add(n + extraCandies >= maxCandies);
        }

        return result;
    }
}

// [2,3,5,1,3], 3