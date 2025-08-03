class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || extraCandies <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Boolean> result = new ArrayList<>();

        int maxCandies = 0;
        for (int currCandies : candies) {
            maxCandies = Math.max(maxCandies, currCandies);
        }

        for (int currCandies : candies) {
            boolean isGreatest = currCandies + extraCandies >= maxCandies;
            result.add(isGreatest);
        }
        
        return result;
    }
}

// time  - O(n)
// space - O(n)