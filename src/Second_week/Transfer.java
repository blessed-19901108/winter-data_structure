package Second_week;

import java.util.Scanner;

public class Transfer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //矩阵阶数
        int n = 4;
        int[][] array = new int[n][n];
        //读入矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        //Warshall算法求传递闭包 看第一列有没有1，有1的那一行和第一行相与
        //https://blog.csdn.net/foreverzili/article/details/68481930
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (array[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        array[i][k] = array[i][k] | array[j][k];
                    }
                }
            }
        }
        //输出传递闭包
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

}
