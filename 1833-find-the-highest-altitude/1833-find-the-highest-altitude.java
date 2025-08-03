class Solution {
    public int largestAltitude(int[] gain) {
        if (gain == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int largestAltitude = 0;
        int currentAltitude = 0;
        for (int difference : gain) {
            currentAltitude += difference;
            largestAltitude = Math.max(largestAltitude, currentAltitude);
        }
        return largestAltitude;
    }
}