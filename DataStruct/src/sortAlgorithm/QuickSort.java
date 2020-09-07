package sortAlgorithm;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 3, 4, 7, 9, 6, 1, 0};
        quickSort(array, 0, 9);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        //中轴值，基准
        int pivot = array[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            //找到左边比pivot大的值
            while (array[l] < pivot) {
                l++;
            }
            //找到右边比pivot小的值
            while (array[r] > pivot) {
                r--;
            }
            //pivot左边的所有值全部小于pivot的值，右边全部是大于pivot的值
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            //如果交换完后，如果array[l] = pivot
            if (array[l] == pivot) {
                r--;
            }
            if (array[r] == pivot) {
                l++;
            }
        }
        //如果l=r,必须l++、r--否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(array, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(array, l, right);
        }
    }
}
