class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || endGene == null || startGene.length() != 8 || endGene.length() != 8 || bank == null) {
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
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (Objects.equals(curr, endGene)) {
                    return count;
                }
                char[] currArray = curr.toCharArray();
                for (int j = 0; j < curr.length(); j++) {
                    char oldChar = currArray[j];
                    for (char g : genes) {
                        if (g == oldChar) continue;
                        currArray[j] = g;
                        String newGene = new String(currArray);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            q.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    currArray[j] = oldChar;
                }
            }
            count++;
        }
        
        return -1;
    }
}