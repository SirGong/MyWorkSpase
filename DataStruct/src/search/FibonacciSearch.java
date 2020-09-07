package search;

import java.util.Arrays;

public class FibonacciSearch {
    static int maxSize = 20;

    public static void main(String[] args) {
        int [] arr = {12,45,69,78,95,456,7895};
        System.out.println(fibonacciSearch(arr,456));

    }

    //得一个斐波那契数列
    public static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
    //斐波那契查找算法
    public static int fibonacciSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放mid值
        int f[] = fib();
        //获取到斐波那契分割数值的下标
        while (high>f[k]-1){
            k++;
        }
        //f[k] 不一定等于数组的长度，可能大于
        int[] temp = Arrays.copyOf(arr,f[k]);
        for (int i = high+1; i <temp.length ; i++) {
            temp[i] = arr[high];
        }
        //使用循环来寻找我们需要的Key值
        while(low<=high){
            mid = low +f[k]-1;
            if(temp[mid]>key){
                //向数组的左边继续查找
                high = mid-1;
                //说明：k--? why？
                //全部元素=前面的元素+后面元素
                //前面有f[k-1]个元素
                k--;
            }else if(temp[mid]<key){
                low = mid+1;
                k-=2;
            }else { //找到,返回较小的索引值
                if(mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
