class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (i > 0) {
                if ((c == 'V' || c == 'X') && s.charAt(i - 1) == 'I') {
                    result += map.get(c) - map.get('I');
                    i--;
                } else if ((c == 'L' || c == 'C') && s.charAt(i - 1) == 'X') {
                    result += map.get(c) - map.get('X');
                    i--;
                } else if ((c == 'D' || c == 'M') && s.charAt(i - 1) == 'C') {
                    result += map.get(c) - map.get('C');
                    i--;
                } else {
                    result += map.get(c);
                }
            } else {
                result += map.get(c);
            }
        }

        return result;
    }
}