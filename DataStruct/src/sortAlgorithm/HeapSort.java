package sortAlgorithm;


import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, -1, 6, 8, 77, 92, 15, -3, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序~~");
        //首先完成大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }


    }
    //此方法用来调整成为大顶堆

    /**
     * 完成将以 i 对应的非叶子节点的树调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整，length相继减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//保存当前节点数据
        //开始调整
        //
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            //左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//指向右子节点
            }
            //子节点的值大于父节点的值
            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大的值赋值给当前节点
                i = k;//继续调整值较大的子节点
            } else {
                break;//从左至右，从下至上
            }
        }
        //for循环结束后，已经将以i为父节点的值放在了顶上，局部调整好了
        arr[i] = temp;
    }
}
