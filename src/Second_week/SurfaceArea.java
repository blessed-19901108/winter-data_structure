package Second_week;

public class SurfaceArea {
    //三维数组的高维度是写在最前面的，也就是立方体的z
    // cube[高][行][列]  cube[上下][左右][前后]
    //一层一层的填数字0和数字1，0代表该位置没有方块，1代表该位置有方块

    /**
     * 第1层和第7层 这两层所有位置都没有方块，全部填0 n代表层数
     */
    public static void layer1(int[][][] a, int n) {
        for (int i = 0; i < a[n].length; i++) {
            for (int j = 0; j < a[n][i].length; j++) {
                a[n][i][j] = 0;
            }
        }

    }

    /**
     * 第2层和第6层 有方块的位置比没有方块的位置多，所以先全部填1，再选择个别位置填0 n代表层数
     */
    public static void layer2(int[][][] a, int n) {
        for (int i = 0; i < a[n].length; i++) {
            for (int j = 0; j < a[n][i].length; j++) {
                a[n][i][j] = 1;
                if (i == 0 || i == 6) {
                    a[n][i][j] = 0;
                }
                if (j == 0 || j == 6) {
                    a[n][i][j] = 0;
                }
            }
        }
        a[n][2][3] = 0;
        a[n][3][3] = 0;
        a[n][4][3] = 0;
        a[n][3][2] = 0;
        a[n][3][4] = 0;
    }

    /**
     * 第3层和第5层 有方块的位置比没有方块的位置多，所以先全部填1，再选择个别位置填0 n代表层数
     */
    public static void layer3(int[][][] a, int n) {
        for (int i = 0; i < a[n].length; i++) {
            for (int j = 0; j < a[n][i].length; j++) {
                a[n][i][j] = 1;
                if (i == 0 || i == 3 || i == 6) {
                    a[n][i][j] = 0;
                }
                if (j == 0 || j == 3 || j == 6) {
                    a[n][i][j] = 0;
                }
            }
        }
    }

    /**
     * 第4层 没有方块的位置比有方块的位置多，所以先全部填0，再选择个别位置填1 n代表层数
     */
    public static void layer4(int[][][] a, int n) {
        for (int i = 0; i < a[n].length; i++) {
            for (int j = 0; j < a[n][i].length; j++) {
                a[n][i][j] = 0;
            }
        }
        a[n][1][1] = 1;
        a[n][1][5] = 1;
        a[n][5][1] = 1;
        a[n][5][5] = 1;
    }

    public static void main(String[] args) {
        //7层分别填数 根据每层的情况不同而调用不同的函数
        int[][][] cube = new int[7][7][7];
        SurfaceArea.layer1(cube, 0);
        SurfaceArea.layer2(cube, 1);
        SurfaceArea.layer3(cube, 2);
        SurfaceArea.layer4(cube, 3);
        SurfaceArea.layer3(cube, 4);
        SurfaceArea.layer2(cube, 5);
        SurfaceArea.layer1(cube, 6);

        /**输出三维数组*/
        for (int i = 0; i < cube.length; i++) {
            for (int i1 = 0; i1 < cube[i].length; i1++) {
                for (int i2 = 0; i2 < cube[i][i1].length; i2++) {
                    System.out.print(cube[i][i1][i2]);
                }
                //二维换行
                System.out.println();
            }
            //三维换行
            System.out.println();
        }

        //!!!!注意：挖空的正方体不能要，前提是有正方体存在，才能有“6”可以减去 挨着的面
        //设置  一个数组记下5*5*5的每个小方块周围挨着的小方块的个数，将来是要被减去的
        /*int[] minus = new int[5*5*5];
        //minus的下标
        int sub = 0;
        for(int i = 1;i<cube.length-1;i++) {
            for(int j = 1;j<cube.length-1;j++) {
                for(int k = 1;k<cube.length-1;k++){
                    minus[sub] =cube[i-1][j][k]+cube[i+1][j][k]+
                              cube[i][j-1][k]+cube[i][j+1][k]+
                              cube[i][j][k-1]+cube[i][j][k+1];
                    sub++;
                }
            }
        }
        //5*5*5个小方块的面积
        int sum = 5*5*5*6;
        for(int i =0;i<minus.length;i++){
            sum =sum - minus[i];
        }
        System.out.print(sum);
         */

        int num = 0;
        for (int i = 1; i < cube.length - 1; i++) {
            for (int j = 1; j < cube[i].length - 1; j++) {
                for (int k = 1; k < cube[i][j].length - 1; k++) {
                    if (cube[i][j][k] == 1) {
                        num += 6 - (cube[i - 1][j][k] + cube[i + 1][j][k]
                                + cube[i][j + 1][k] + cube[i][j - 1][k]
                                + cube[i][j][k + 1] + cube[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.print(num);
    }
}
