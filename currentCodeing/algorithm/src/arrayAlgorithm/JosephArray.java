package arrayAlgorithm;

/**
 * 采用数组方式解决约瑟夫环
 */
public class JosephArray {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(10, 5));
    }
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;
        int[] arr = new int[n];
        //将所有的编号放入数组当中
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        //每次出去一个，记录数加一
        int count = 0;
        int i = 0;
        while (count < n-1) {
            //要将每一个该出圈的成员置零
            if (arr[(i + m - 1) % n] != 0) {
                arr[(i + m - 1) % n] = 0;
                count++;
            } else {
                i += m;
            }
        }
        int res = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0)
                res = arr[j];
        }
        return res;
    }
}
