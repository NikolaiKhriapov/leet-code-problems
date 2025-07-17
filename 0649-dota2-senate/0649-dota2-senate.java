class Solution {
    private static final char CHAR_1 = 'R';
    private static final char CHAR_2 = 'D';
    private static final String NAME_1 = "Radiant";
    private static final String NAME_2 = "Dire";

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isBlank()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            switch (c) {
                case CHAR_1 -> queue1.offer(i);
                case CHAR_2 -> queue2.offer(i);
                default -> throw new IllegalArgumentException("Invalid input");
            }
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int idx1 = queue1.poll();
            int idx2 = queue2.poll();
            if (idx1 < idx2) {
                queue1.offer(idx1 + senate.length());
            } else {
                queue2.offer(idx2 + senate.length());
            }
        }
        
        return !queue1.isEmpty() ? NAME_1 : NAME_2;
    }
}