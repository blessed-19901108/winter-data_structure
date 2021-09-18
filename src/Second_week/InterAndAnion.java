package Second_week;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InterAndAnion {
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
        }
        int nums1[] = Arrays.copyOfRange(a, 0, 1000);
        int nums2[] = Arrays.copyOfRange(a, 9000, 10000);
//        int nums1[] = Arrays.copyOfRange(a, 0, 100);
//        int nums2[] =  Arrays.copyOfRange(a, 9900, 10000);

        //排序后取交集 Inter:Intersection交集
        /**先排序，谁小谁往后移，谁大谁留在原地，相同加入新的数组
         * 循环条件：只要有一个数组走完就比完了
         * 时间复杂度：O(m+n) m、n为两个数组中的元素个数
         * */

        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        //开始时间 获取当前系统时间(纳秒) 排序不要计入比较时间
        long startTime = System.nanoTime();
        int index1=0,index2 = 0,index = 0;
        int[] inter = new int[nums1.length];
        //两个条件有一个不满足就跳出来
        while(index1!=nums1.length && index2!=nums2.length)
        {
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else{
                inter[index] = nums1[index1];
//                System.out.print(inter[index]+"  ");
                index++;
                index1++;//取完之后两边的下标都要加
                index2++;
            }
        }
        //去重法2：对于原始数组用二重循环，让数组的第一个数与其后的所有数比较，若不同则将第一个数存入一个新数组。
        //交集去重 Deduplication
        Set<Integer> Ded=new HashSet<Integer>();
        for(int i=0;i<inter.length;i++) {
            if(inter[i]!=0) {
//                System.out.print(inter[i] + "  ");
                Ded.add(inter[i]);
            }
        }
//        System.out.println(Ded.size());
        long consumingTime = System.nanoTime() - startTime;
//        System.out.println();
//        System.out.println("排序交集时间：");
        System.out.println( consumingTime);

         */


        //未排序取交集
        /**以第一个数组为主，比较两个数组的所有的数，相同加入新的数组
         * 循环条件：遍历两个数组的所有元素
         * 时间复杂度：m*n
         * */
        //开始时间 获取当前系统时间(纳秒)
        /*long startTime = System.nanoTime();
        int index1=0,index2 = 0,index = 0;
        int[] inter = new int[nums1.length];
        for(index1 = 0;index1<nums1.length;index1++) {
            for(index2 = 0;index2<nums2.length;index2++){
                if(nums1[index1]==nums2[index2]){
                    inter[index] = nums1[index1];
//                    System.out.print(inter[index]+"  ");
                    index++;
                }
            }
        }

        //交集去重 Deduplication
        Set<Integer> Ded=new HashSet<Integer>();
        for(int i=0;i<inter.length;i++) {
            if(inter[i]!=0) {
//                System.out.print(inter[i] + "  ");
                Ded.add(inter[i]);
            }
        }
//        System.out.println(Ded.size());
        long consumingTime = System.nanoTime() - startTime;
//        System.out.println("未排序交集时间：");
        System.out.println( consumingTime);*/


        //排序并集
        /**先排序，谁小谁加入新数组，并且对应数组的指针往后移，相同就取数组一
         * 循环条件：走完其中一个数组即可，另一个剩下的数组重开一个循环
         * */
        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        //开始时间 获取当前系统时间(纳秒) 排序不要计入比价时间
        long startTime = System.nanoTime();
        int index1=0,index2 = 0,index = 0;
        int[] anion = new int[nums1.length+nums2.length];
        //两个条件有一个不满足就跳出来
        while(index1!=nums1.length && index2!=nums2.length)
        {
            if(nums1[index1]<nums2[index2]){
                anion[index] = nums1[index1];
                index++;
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                anion[index] = nums2[index2];
                index++;
                index2++;
            }else{
                anion[index] = nums1[index1];
                index++;
                index1++;//取完之后两边的下标都要加
                index2++;
            }
        }
        while(index1<nums1.length){
            anion[index] = nums1[index1];
            index++;
            index1++;
        }
        while(index2<nums2.length){
            anion[index] = nums2[index2];
            index++;
            index2++;
        }
//        System.out.println( Arrays.toString(anion));
        //并集去重 Deduplication
        Set<Integer> Ded=new HashSet<Integer>();
        for(int i=0;i<anion.length;i++) {
            if(anion[i]!=0) {
                Ded.add(anion[i]);
            }
        }
//        System.out.println(Ded.size());
        long consumingTime = System.nanoTime() - startTime;
//        System.out.println("排序并集时间：");
        System.out.println(consumingTime);

         */


        //未排序并集
        /**两个数组对应元素相比较
         * 循环条件：走完其中一个数组即可，另一个剩下的数组重开一个循环
         * */
        //开始时间 获取当前系统时间(纳秒)
        long startTime = System.nanoTime();
        int index1 = 0, index2 = 0, index = 0;
        int[] anion = new int[nums1.length + nums2.length];
        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1] != nums2[index2]) {
                anion[index] = nums1[index1];
                anion[index + 1] = nums2[index2];
                index = index + 2;
                index1++;
                index2++;
            } else {
                anion[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        while (index1 < nums1.length) {
            anion[index] = nums1[index1];
            index++;
            index1++;
        }
        while (index2 < nums2.length) {
            anion[index] = nums2[index2];
            index++;
            index2++;
        }
        //并集去重 Deduplication
        Set<Integer> Ded = new HashSet<Integer>();
        for (int i = 0; i < anion.length; i++) {
            if (anion[i] != 0) {
                Ded.add(anion[i]);
            }
        }
//        System.out.println(Ded.size());
        long consumingTime = System.nanoTime() - startTime;
//        System.out.println("未排序并集时间：");
        System.out.println(consumingTime);


    }
}
