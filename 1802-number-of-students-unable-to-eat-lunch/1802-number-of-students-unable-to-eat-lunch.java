class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();
        for (int n : students) {
            queue.add(n);
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }

        int rep = 0;
        int maxReps = students.length;
        while (!queue.isEmpty() && rep <= maxReps) {
            int st = queue.poll();
            if (st != stack.peek()) {
                queue.add(st);
                rep++;
            } else {
                stack.pop();
                maxReps--;
                rep = 0;
            }
        }

        return queue.size();
    }
}