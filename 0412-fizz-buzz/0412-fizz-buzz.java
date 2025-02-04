class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) {
                    s.append("Fizz");
                }
                if (i % 5 == 0) {
                    s.append("Buzz");
                }
                result.add(new String(s));
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}