package First_week;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sort1 {
    public static void bubbleSort(int[] a, int n) {
        int j, k;
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
    }

    //T_BS:time_bubbleSort :冒泡排序所用时间
    public static void T_BS(int[] a, int n) {
        long startTime = System.nanoTime();    //开始时间 获取当前系统时间(纳秒)
        Sort1.bubbleSort(a, n);
        //消耗时间
        long consumingTime = System.nanoTime() - startTime;
        System.out.println("前" + n + "个数" + "冒泡排序消耗时间--" + consumingTime + "纳秒");

    }

    //T_S:time_Sort :sort排序所用时间
    public static void T_S(int[] a, int n) {
        long startTime = System.nanoTime();    //开始时间 获取当前系统时间(纳秒)
        Arrays.sort(a);
//        for(int i = 0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
        //消耗时间
        long consumingTime = System.nanoTime() - startTime;
        System.out.println("前" + n + "个数" + "sort排序消耗时间--" + consumingTime + "纳秒");

    }

    /**TXT是一个文本文件，一般采用流的方式读取：   java提供了一个FileInputStream，我们可以直接以文件路径构造这个流，
     * 也可以以文件对象构造他，如:FileInputStream fin = new FileInputStream("d:/aa.txt");
     * 然后使用这个流就可以直接读取到文件了，但是这个时候读取到的内容是int类型的数值，所以需要进一步的处理，我们把fin外面包
     * 上一个InputStreamReader，就变成了这样：   InputStreamReader reader = new InputStreamReader(fin);
     * 但是这一个reader读取文本并不是很方便，有一点要注意，在这一个reader的构造方法上面可以设定字符编码；接下来，
     * 使用这个reader构造BufferedReader，BufferedReader拥有一个名为readLine的方法，可以读取一整行的文本，
     * 作为字符串返回，因此用起来会比较方便。 BufferedReader buffReader = new BufferedReader(reader);
     * 接下来就是借助循环来读取文件中的字符串了，然后，去做你想做的事情好了*/

    /**
     * 如果使用方法函数就会出现多核调用，运行时间或有问题，最好是一个方法改一下数量
     */
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
            Sort1.T_BS(Arrays.copyOfRange(a, 0, 100), 100);
            Sort1.T_BS(Arrays.copyOfRange(a, 0, 1000), 1000);
            Sort1.T_BS(Arrays.copyOfRange(a, 0, 10000), 10000);

            //sort排序消耗时间
            Sort1.T_S(Arrays.copyOfRange(a, 0, 100), 100);
            Sort1.T_S(Arrays.copyOfRange(a, 0, 1000), 1000);
            Sort1.T_S(Arrays.copyOfRange(a, 0, 10000), 10000);

        }

    }
}
