package recursion;

/*八皇后思路：
1)第一个皇后先放第一行第一列
2)第二个皇后放在第二行第-列、然后判断是否0K，如果不oK,继续放在第二列、第三列、依次把所有列都放完，找到一个合适
3)继续第三个皇后，还是第一列、第二列...直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解4)当得到一个正确解时，
    在栈回退到上一个栈时，就会开始回溯，即将第-一个皇后，放到第-列的所有正确解,全部得到.
5)然后回头继续第一一个 皇后放第二列,后面继续循环执行1,2,3,4的步骤
 */
public class Queue8 {
    static int COUNT = 0;
    int max = 8;//有多少皇后
    int[] array = new int[max];//array表示放置皇后的位置的结果

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有" + COUNT + "种方法");

    }

    //编写一个方法
    //放置的第n个皇后与之前放置的额皇后进行位置比较，看是否冲突
    public void check(int n) {
        if (n == max) { //已经将八个皇后摆好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;//先把当前这个皇后放到当前的第一列
            //判断第i个皇后放置到底i列是否冲突
            if (judge(n)) {//不冲突
                //接着放第n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i ，即将皇后向后移动一个位置
        }
    }
    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //说明：
            //1.array[i] == array[n] 判断新皇后与之前的皇后是否在同一列
            //2.Math.abs(n-i)==Math.abs(array[n]-array[i])第n个皇后是否和第i个皇后在同一斜线
            //此方法不用判断是否在同一行
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        COUNT++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }
}
