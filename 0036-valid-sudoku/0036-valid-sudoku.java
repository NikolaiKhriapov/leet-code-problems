class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean isRowsValid = isRowsValid(board);
        boolean isColumnsValid = isColumnsValid(board);
        boolean isSubboxesValid = isSubboxesValid(board);
        
        return isRowsValid && isColumnsValid && isSubboxesValid;
    }

    private boolean isRowsValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char curr = board[i][j];
                if (curr == '.') continue; 
                boolean isAdded = set.add(curr);
                if (!isAdded) return false;
            }
        }
        return true;
    }

    private boolean isColumnsValid(char[][] board) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Set<Character> set = map.getOrDefault(j, new HashSet<>());
                char curr = board[i][j];
                if (curr == '.') continue; 
                boolean isAdded = set.add(curr);
                if (!isAdded) return false;
                map.put(j, set);
            }
        }
        return true;
    }

    private boolean isSubboxesValid(char[][] board) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int subsection;
                if (i < 3) {
                    if (j < 3) subsection = 0;
                    else if (j < 6) subsection = 1;
                    else subsection = 2;
                } else if (i < 6) {
                    if (j < 3) subsection = 3;
                    else if (j < 6) subsection = 4;
                    else subsection = 5;
                } else {
                    if (j < 3) subsection = 6;
                    else if (j < 6) subsection = 7;
                    else subsection = 8;
                }

                Set<Character> set = map.getOrDefault(subsection, new HashSet<>());

                char curr = board[i][j];
                if (curr == '.') continue; 
                boolean isAdded = set.add(curr);
                if (!isAdded) return false;

                map.put(subsection, set);
            }
        }
        return true;
    }
}