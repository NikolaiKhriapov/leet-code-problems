class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();

        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
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
                result.insert(map.get(remainder), "(");
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

//  40 / 333 = 0 |  40 % 333 = 40 * 10 = 400
// 400 / 333 = 1 | 400 % 333 = 67 * 10 = 670
// 670 / 333 = 2 | 670 % 333 =  4 * 10 = 40
