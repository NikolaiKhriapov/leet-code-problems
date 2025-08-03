class Solution {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            result.add(!sb.isEmpty() ? sb.toString() : String.valueOf(i));
        }
        return result;
    }
}