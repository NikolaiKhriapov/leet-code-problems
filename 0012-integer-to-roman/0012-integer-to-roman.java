class Solution {
    public String intToRoman(int num) {

        Map<Integer, Character> map = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M'
        );
        
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            int currNum = 0;
            for (var entry : map.entrySet()) {
                int curr = entry.getKey();
                if (curr <= num && curr > currNum) currNum = curr;
            }
            result.append(map.get(currNum));
            num -= currNum;
        }

        return result.toString()
                     .replaceAll("DCCCC", "CM")
                     .replaceAll("CCCC", "CD")
                     .replaceAll("LXXXX", "XC")
                     .replaceAll("XXXX", "XL")
                     .replaceAll("VIIII", "IX")
                     .replaceAll("IIII", "IV");
    }
}

// 3749