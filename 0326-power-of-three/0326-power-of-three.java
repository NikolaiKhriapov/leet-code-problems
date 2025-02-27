class Solution {
    public boolean isPowerOfThree(int n) {  
        if (n < 1) {
            return false;
        }

        if (Math.pow(3, 21) % n == 0) {
            return true;
        }
        
        return false;
    }
}