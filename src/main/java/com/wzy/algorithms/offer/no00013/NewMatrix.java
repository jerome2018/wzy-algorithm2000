
package com.wzy.algorithms.offer.no00013;

/**
 * FileName: Solution
 * Description: 二维子矩阵的和
 * Author: wangzhenyue
 * Date: 2023/6/29 14:00
 */
public  class NewMatrix {
    int[][] sums; //定义一个二维矩阵，存放原始二维矩阵matrix的前缀和

    public  NewMatrix(int[][] matrix) { //输入一个二维矩阵，然后求出初始化一个前缀和二维数组

        int m = matrix.length; //二维矩阵的行数
        if (m > 0) { //排除二维矩阵为空
            int n = matrix[0].length; //二维矩阵列数
            sums = new int[m][n+1]; //创建m行n+1列前缀和矩阵
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j+1] = sums[i][j] + matrix[i][j]; //二维矩阵的每一行的的前缀和数组初始化
                }
            }
        }

    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){ //按行遍历
            sum += sums[i][col2+1] - sums[i][col1]; //累加求和，由于sums二维矩阵是m行n+1列，这样就不必特殊处理第一列的数据了，因为n+1列已经包进去了
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NewMatrix numMatrix = new NewMatrix(matrix);
        int sum = numMatrix.sumRegion(2,1,4,3);
        System.out.println(sum);
    }
}
