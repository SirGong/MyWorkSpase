package sortAlgorithm;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);

    }
    //如果有负数需要进行特殊处理
    public static void radixSort(int[] arr) {
        //针对每个元素的各位进行处理
        //定义一个二维数组，一共10个桶，每个桶 arr.length为了防止数据溢出
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中实际放入多少个数据
        //bucketElementCount[0] 记录这个桶放入的数据位数为0
        int[] bucketElementCount = new int[10];
        //假设第一个数为数组最大的数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到的最大的数，判断的它的位数
        int maxLength = (max + "").length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第一次处理个位，第二次处理十位，以此类推
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                //放入到对应桶里
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }
            //按照桶的顺序依次取出数据放入原来的数组
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                //如果桶中有数据，才取出放入原数组
                if (bucketElementCount[k] != 0) {
                    //循环第k个桶
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        //取出元素，放入arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //置零，防止计数错误
                bucketElementCount[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮处理后的结果为：" + Arrays.toString(arr));
        }


    }
}
