class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || endGene == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(startGene);
        visited.add(startGene);
        
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String currGene = q.poll();
                if (Objects.equals(currGene, endGene)) {
                    return count;
                }
                char[] currGeneArr = currGene.toCharArray();
                for (int i = 0; i < currGeneArr.length; i++) {
                    char oldChar = currGeneArr[i];
                    for (char g : genes) {
                        if (g == oldChar) {
                            continue;
                        }
                        currGeneArr[i] = g;
                        String newGene = new String(currGeneArr);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            q.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    currGeneArr[i] = oldChar;
                }
            }
            count++;
        }
        return -1;
    }
}