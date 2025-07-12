class Solution {
    private static final char CHAR_1 = 'R';
    private static final char CHAR_2 = 'D';
    private static final String NAME_1 = "Radiant";
    private static final String NAME_2 = "Dire";

    public String predictPartyVictory(String senate) {
        if (senate == null || senate.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            switch (senate.charAt(i)) {
                case CHAR_1 -> queue1.add(i);
                case CHAR_2 -> queue2.add(i);
                default -> throw new IllegalArgumentException("Invalid input");
            }
        }
        
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int idx1 = queue1.poll();
            int idx2 = queue2.poll();
            if (idx1 < idx2) {
                queue1.add(idx1 + senate.length());
            } else {
                queue2.add(idx2 + senate.length());
            }
        }

        return queue1.isEmpty() ? NAME_2 : NAME_1;
    }
}