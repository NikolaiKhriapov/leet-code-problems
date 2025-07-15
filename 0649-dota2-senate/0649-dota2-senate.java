class Solution {
    private static final char CHAR_1 = 'R';
    private static final char CHAR_2 = 'D';
    private static final String NAME_1 = "Radiant";
    private static final String NAME_2 = "Dire";

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            switch (ch) {
                case CHAR_1 -> queue1.offerLast(i);
                case CHAR_2 -> queue2.offerLast(i);
            }
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int a = queue1.pollFirst();
            int b = queue2.pollFirst();
            if (a < b) {
                queue1.offerLast(a + senate.length());
            } else {
                queue2.offerLast(b + senate.length());
            }
        }

        return !queue1.isEmpty() ? NAME_1 : NAME_2;
    }
}