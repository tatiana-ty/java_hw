package lesson_h;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[5][7];
        fill_matrix(arr);
    }

    private static void fill_matrix (int[][] arr) {
        int row = 0;
        int cell = 0;
        int value = 1;
        int circle = 0;

        int maxCircle = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
        while (circle < maxCircle) {
            while (cell < arr[0].length - circle) {
                arr[row][cell] = value;
                if (circle != maxCircle - 1 || arr.length % 2 == 0)
                    arr[arr.length - row - 1][cell] = value + (arr[0].length - circle * 2) * 2 + (arr.length - circle * 2 - 2) - cell * 2 - 1 + circle * 2;
                cell++;
                value++;
            }
            if (circle != maxCircle - 1) {
                cell = cell - 1;
                row += 1;
                while (row < arr.length - 1 - circle) {
                    arr[row][cell] = value;
                    arr[row][circle] = value + (arr[0].length - circle * 2) + (arr.length - circle * 2 - 2) * 2 - row * 2 + 1 + circle * 2;
                    row++;
                    value++;
                }
            }
            value += (arr.length - circle * 2) + (arr[0].length - circle * 2) - 2;
            circle++;
            cell = circle;
            row = circle;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(String.format("%02d", arr[i][j]) + " ");
            System.out.println();
        }
    }
}
