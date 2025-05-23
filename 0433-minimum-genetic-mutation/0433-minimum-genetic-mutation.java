class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || endGene == null || startGene.length() != 8 || endGene.length() != 8 || bank == null) {
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
            while (size-- > 0) {
                String currGene = queue.poll();
                if (Objects.equals(currGene, endGene)) return count;
                char[] currGeneArr = currGene.toCharArray();
                for (int i = 0; i < currGeneArr.length; i++) {
                    char oldG = currGeneArr[i];
                    for (char g : genes) {
                        if (g == oldG) continue;
                        currGeneArr[i] = g;
                        String newGene = new String(currGeneArr);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    currGeneArr[i] = oldG;
                }
            }
            count++;
        }
        return -1;
    }
}