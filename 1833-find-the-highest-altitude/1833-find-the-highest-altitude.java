class Solution {
    public int largestAltitude(int[] gain) {
        if (gain == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxAltitude = 0;
        int currAltitude = 0;
        for (int currGain : gain) {
            currAltitude += currGain;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }
        return maxAltitude;
    }
}