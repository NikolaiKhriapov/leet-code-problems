class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0 || buildings[0].length != 3) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<int[]> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new int[] {building[0], -building[2]});
            events.add(new int[] {building[1], building[2]});
        }
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        pq.add(0);

        int prevHeight = 0;
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            if (h < 0) {
                pq.add(-h);
            } else {
                pq.remove(h);
            }
            int currHeight = pq.peek();
            if (currHeight != prevHeight) {
                result.add(List.of(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}