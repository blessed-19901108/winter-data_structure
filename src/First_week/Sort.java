package First_week;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) throws IOException {
        //读取txt文档
        File f = new File("D:/datafile.txt");
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String str;

        int[] a = new int[10000];
        while ((str = bf.readLine()) != null) {
            String[] s = str.split(",");
            //将String数组转化为int数组
            for (int i = 0; i < s.length; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            //int a100[] = Arrays.copyOfRange(a, 0, 100); //[from,to)即不包括第100个
            //冒泡排序消耗时间
            /*
            long startTime = System.nanoTime();

            int j, k;//循环要用到的下标
            int n = 100;//数组个数
            int flag = n;// flag来记录最后交换的位置，也就是排序的尾边界

            while (flag > 0) {// 排序未结束标志
                k = flag; // k 来记录遍历的尾边界
                flag = 0;

                for (j = 1; j < k; j++) {
                    if (a[j - 1] > a[j]) {// 前面的数字大于后面的数字就交换
                        // 交换a[j-1]和a[j]
                        int temp;
                        temp = a[j - 1];
                        a[j - 1] = a[j];
                        a[j] = temp;

                        // 表示交换过数据;
                        flag = j;// 记录最新的尾边界.
                    }
                }
            }
            long consumingTime = System.nanoTime() - startTime;
            System.out.println(consumingTime);
            */

            //sort排序消耗时间
            int n = 100;//数组个数
            long startTime = System.nanoTime();    //开始时间 获取当前系统时间(纳秒)
            Arrays.sort(a);
//        for(int i = 0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
            //消耗时间
            long consumingTime = System.nanoTime() - startTime;
            System.out.println(consumingTime);
        }
    }
}
