package Second_week;

import java.util.Arrays;

public class IAAText {
    //排序交集
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 != len1 && index2 != len2) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                arr[index] = nums2[index2];
                index++;
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    //未排序交集
    public static int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        for (index1 = 0; index1 < nums1.length; index1++) {
            for (index2 = 0; index2 < nums2.length; index2++) {
                if (nums1[index1] == nums2[index2]) {
                    arr[index] = nums1[index1];
                    index++;
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    //排序并集
    public static int[] anion1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        //两个条件有一个不满足就跳出来
        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                arr[index] = nums1[index1];
                index++;
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                arr[index] = nums2[index2];
                index++;
                index2++;
            } else {
                arr[index] = nums1[index1];
                index++;
                //取完之后两边的下标都要加
                index1++;
                index2++;
            }
        }
        while (index1 < nums1.length) {
            arr[index] = nums1[index1];
            index++;
            index1++;
        }
        while (index2 < nums2.length) {
            arr[index] = nums2[index2];
            index++;
            index2++;
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    //未排序并集
    public static int[] anion2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 != nums1.length && index2 != nums2.length) {
            if (nums1[index1] != nums2[index2]) {
                arr[index] = nums1[index1];
                arr[index + 1] = nums2[index2];
                index = index + 2;
                index1++;
                index2++;
            } else {
                arr[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }
        while (index1 < nums1.length) {
            arr[index] = nums1[index1];
            index++;
            index1++;
        }
        while (index2 < nums2.length) {
            arr[index] = nums2[index2];
            index++;
            index2++;
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    public static void main(String[] args) {
        int[] before = {1, 2, 3, 5, 8, 9};
        int[] after = {1, 4, 6, 5};
//        int[] a1 = IAAText.intersect1(before,after);
//        int[] a2 = IAAText.intersect2(before,after);
        int[] a3 = IAAText.anion2(before, after);
//        int[] a4 = IAAText.anion1(before,after);
        for (int i = 0; i < a3.length; i++) {
            System.out.println(a3[i]);
        }
    }
}
