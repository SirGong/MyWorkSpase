package sortAlgorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println("归并排序前的数组为：" + Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后的数组为：" + Arrays.toString(arr));
    }

    //分治方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);

        }

    }
    //合并的方法

    /**
     * @param arr   待排序的数组
     * @param left  左边有序序列的初始值
     * @param mid   中间索引
     * @param right 右边有序序列最右边的索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化，指向左边有序序列的左边索引
        int j = mid + 1;
        int t = 0;
        //  将左右两边的有序序列的数按照规则填充进temp中
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
            } else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        //把剩余一边有数据的填充到temp中
        while (i <= mid) {//左边还有剩余元素
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //把temp拷贝到arr中
        t = 0;
        int tempLeft = left;//因为分治，所以每次拷贝的并不是原来所有的数组
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }


    }
}
