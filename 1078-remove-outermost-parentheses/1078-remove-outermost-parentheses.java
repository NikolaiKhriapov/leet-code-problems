class Solution {
    public String removeOuterParentheses(String s) {

        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int p = 0;
        for (char c : s.toCharArray()) {
            list.add(c);
            if (c == '(') p++;
            else p--;
            if (p == 0) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (i == 0) continue;
                    else sb.append(list.get(i));
                }
                list = new ArrayList<>();
            }
        }
        return new String(sb);
    }
}