class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || endGene == null || bank == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startGene);
        visited.add(startGene);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (Objects.equals(curr, endGene)) return count;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char g : genes) {
                        if (g == old) continue;
                        arr[j] = g;
                        String newGene = new String(arr);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    arr[j] = old;
                }
            }
            count++;
        }
        
        return -1;
    }
}