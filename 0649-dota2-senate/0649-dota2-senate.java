class Solution {
    private final static char CHAR_1 = 'R';
    private final static char CHAR_2 = 'D';
    private final static String NAME_1 = "Radiant";
    private final static String NAME_2 = "Dire";

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            switch (ch) {
                case CHAR_1 -> queue1.add(i);
                case CHAR_2 -> queue2.add(i);
                default -> throw new IllegalArgumentException("Invalid input");
            }
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int a = queue1.poll();
            int b = queue2.poll();
            if (a < b) {
                queue1.add(a + senate.length());
            } else {
                queue2.add(b + senate.length());
            }
        }

        return (!queue1.isEmpty()) ? NAME_1 : NAME_2;
    }
}