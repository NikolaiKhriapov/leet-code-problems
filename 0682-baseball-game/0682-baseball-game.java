class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (Objects.equals(op, "+")) {
                Integer tmp = stack.pop();
                Integer score = stack.peek() + tmp;
                stack.push(tmp);
                stack.push(score);
            } else if (Objects.equals(op, "D")) {
                stack.push(2 * stack.peek());
            } else if (Objects.equals(op, "C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }

        return sum;
    }
}

        // List<Integer> list = new ArrayList<>();

        // for (String op : operations) {
        //     if (Objects.equals(op, "+")) {
        //         Integer score = list.get(list.size() - 2) + list.get(list.size() - 1);
        //         list.add(score);
        //     } else if (Objects.equals(op, "D")) {
        //         list.add(2 * list.get(list.size() - 1));
        //     } else if (Objects.equals(op, "C")) {
        //         list.remove(list.size() - 1);
        //     } else {
        //         list.add(Integer.valueOf(op));
        //     }
        // }

        // int sum = 0;
        // for (Integer n : list) {
        //     sum += n;
        // }

        // return sum;
