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
        while (!queue.isEmpty() && rep < students.length) {
            int st = queue.poll();
            if (st != stack.peek()) {
                queue.add(st);
                rep++;
            } else {
                stack.pop();
                rep = 0;
            }
        }

        return queue.size();
    }
}