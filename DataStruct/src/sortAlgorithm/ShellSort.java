package sortAlgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(array);
    }

    public static void shellSort(int[] array) {
        int temp = 0;
        //gap作为希尔排序的步长
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                //遍历各组的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，则交换
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }

    //采用交换法的希尔排序反而变得更慢了
    //优化：改进为移位法
    public static void shellSort2(int[] array) {
        //从第gap个元素逐渐对其各自的组进行直接插入排序
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j - gap >= 0 && temp < array[j - gap]) {
                    //移动
                    array[j] = array[j - gap];
                    j -= gap;
                }
                //循环结束，已经找到插入位置
                array[j] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
