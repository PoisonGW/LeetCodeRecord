package ArraysDemo;

import java.util.Arrays;

/**
 * @description:
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 *
 * @author: Poison
 * @date: 2021年12月15日 21:28:12
 */
public class Demo11 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},};
        rotate(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        /*
        解法1：先上下交换，在斜对角线交换
         */
        int length = matrix.length;
        //上下交换
        for (int i = 0; i < length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length-i-1];
            matrix[length-i-1]= temp;

        }
        //对角线交换
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void rotate1(int[][] matrix) {
        /*
        解法2：直接交换，注意内圈会变小
         */
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = i; j < length-i-1; j++) {
                int m=length-j-1;
                int n=length-i-1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
        }
    }
}
/*
思路：
1.先上下交换，在对角线交换
通过规律先上下交换，在对角线交换即可
2.直接交换
注意下标的对应关系
 */