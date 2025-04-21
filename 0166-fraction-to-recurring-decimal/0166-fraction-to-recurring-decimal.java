class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0)) {
            result.append("-");
        }

        long numeratorLong = Math.abs((long) numerator);
        long denominatorLong = Math.abs((long) denominator);

        result.append(numeratorLong / denominatorLong);
        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) {
            return result.toString();
        }
        result.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int repeatIndex = map.get(remainder);
                result.insert(repeatIndex, "(");
                result.append(")");
                break;
            }

            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / denominatorLong);
            remainder %= denominatorLong;
        }

        return result.toString();
    }
}