class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }

        long numeratorLong = Math.abs((long) numerator);
        long denominatorLong = Math.abs((long) denominator);
        sb.append(numeratorLong / denominatorLong);

        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder > 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / denominatorLong);
            remainder %= denominatorLong;
        }
        
        return sb.toString();
    }
}

// time  - O(n)
// space - O(n)