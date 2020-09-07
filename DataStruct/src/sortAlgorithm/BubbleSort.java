package sortAlgorithm;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println("原始数据为：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        bubbleSort(array);

    }
    //优化：如果在某一趟排序中没有发生一次交换，即已经有序，即可退出
    public static void bubbleSort(int[] array){
        boolean flag = false;//设置标志
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序为：");
//            System.out.println(Arrays.toString(array));
            if(!flag){
                break;
            }else {
                flag = true;
            }
        }
    }
}
