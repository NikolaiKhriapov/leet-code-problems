class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        List<int[]> list = new ArrayList<>();
        for (int[] point : points) {
            list.add(point);
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int right = list.get(i)[1];
            while (i < list.size() && list.get(i)[0] <= right) {
                i++;
            }
            i--;
            count++;
        }
        
        return count;
    }
}

// [[1,6],[2,8],[7,12],[10,16]]