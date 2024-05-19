package msb_algorithm.algorithem;

/**
 * LC 48 旋转图像
 */
public class App_20240423 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int colStart = i;
            int colEnd = len - colStart - 1;
            int gap = colEnd - colStart;

            for (int pos = colStart; pos < colEnd; pos++) {
                int x = i, y = pos, tmp1 = 0, tmp2 = 0, remain = 0;
                for (int time = 0; time < 4; time++) {
                    switch (time) {
                        case 0:
                            if (pos + gap > colEnd) {
                                y = colEnd;
                                remain = pos + gap - colEnd;
                                x = i + remain;
                            } else {
                                y = colEnd;
                            }
                            tmp1 = matrix[x][y];
                            matrix[x][y] = matrix[i][pos];
                            break;
                        case 1:
                            if (x + gap > colEnd) {
                                remain = x +gap - colEnd;
                                x = colEnd;
                                y -= remain;
                            } else {
                                x = colEnd;
                            }
                            tmp2 = matrix[x][y];
                            matrix[x][y] = tmp1;
                            break;
                        case 2:
                            if (y - gap < colStart ) {
                                remain = gap - (y - colStart);
                                y = colStart;
                                x -= remain;
                            } else {
                                y = colStart;
                            }
                            tmp1 = matrix[x][y];
                            matrix[x][y] = tmp2;
                            break;
                        case 3:
                            matrix[i][pos] = tmp1;
                            break;
                    }
                }
            }
        }
    }
}
