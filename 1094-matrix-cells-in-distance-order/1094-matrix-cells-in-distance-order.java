class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        int[][] arr = new int[rows*cols][2];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[idx] = new int[] { i, j };
                idx++;
            }
        }

        Arrays.sort(arr, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return d1 - d2;
        });


        // sort(arr, rCenter, cCenter);

        return arr;
    }

    // public void sort(int[][] arr, int rCenter, int cCenter) {
    //     int[] distance = new int[arr.length];

    //     int counter = 0;
    //     for (int[] cell : arr) {
    //         distance[counter] = Math.abs(cell[0] - rCenter) + Math.abs(cell[1] - cCenter);
    //         counter++;
    //     }

    //     for (int i = 0; i < distance.length - 1; i++) {
    //         for (int j = 0; j < distance.length - 1; j++) {
    //             if (distance[j] > distance[j + 1]) {
    //                 int tmp = distance[j];
    //                 distance[j] = distance[j + 1];
    //                 distance[j + 1] = tmp;

    //                 tmp = arr[j][0];
    //                 arr[j][0] = arr[j+1][0];
    //                 arr[j+1][0] = tmp;

    //                 tmp = arr[j][1];
    //                 arr[j][1] = arr[j+1][1];
    //                 arr[j+1][1] = tmp;
    //             }
    //         }
    //     }
    // }
}