class Solution {
    public void rotate(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        populateMap(map, matrix);
        updateMatrix(map, matrix);
    }

    private void populateMap(Map<Integer, List<Integer>> map, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                List<Integer> currList = map.getOrDefault(j, new ArrayList<>());
                currList.add(matrix[i][j]);
                map.put(j, currList);
            }
        }
    }

    private void updateMatrix(Map<Integer, List<Integer>> map, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> currList = map.get(i);
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = currList.get(matrix.length - 1 - j);
            }
        }
    }
}
