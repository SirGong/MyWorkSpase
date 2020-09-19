package arrayAlgorithm;

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindOnceTwoNumInArray {
    /**
     * @param array
     * @param num1  num1,num2分别为长度为1的数组。传出参数 ,将num1[0],num2[0]设置为返回结果
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        int count = 0;
        //将所有的值以及对应的次数都放入map之中了
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }

    /**
     * 使用异或解决这道题，任何数异或他自己的值都为0
     */
    public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int xor = 0; //用来记录最后得到的二进制
        for (int i = 0; i < array.length; i++)
            xor ^= array[i];
        int index = 1;//xor中最后求得的二进制当中从右向左的位置
        while ((index & xor) == 0)
            index = index << 1;
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i] & index) == 0 )
                result1 ^= array[i];
            else
                result2 ^= array[i];
        }
        num1[0] = result1;
        num2[0] = result2;

    }
}
