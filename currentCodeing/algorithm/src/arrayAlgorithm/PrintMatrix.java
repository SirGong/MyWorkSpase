package arrayAlgorithm;

import java.util.ArrayList;


public class PrintMatrix {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> integers = printMatrixArray(array);
        System.out.println(integers.toString());
    }

    public static ArrayList<Integer> printMatrixArray(int[][] array) {
        ArrayList<Integer> resList = new ArrayList<>();
        //定义矩阵四下的边界
        int up = 0;
        int down = array.length-1;
        int left = 0;
        int right = array[0].length-1;
        //向左向右向上向下遍历之后将边界缩小
        while (true) {
            //第一行向右打印
            for (int i = left; i <= right; i++) {
                resList.add(array[up][i]);
            }
            //向下逼近
            up++;
            if (up > down)
                break;

            //最右边一列向下打印
            for (int i = up; i <= down; i++) {
                resList.add(array[i][right]);
            }
            //向左逼近
            right--;
            if (left > right)
                break;
            //最下边一行向左打印
            for (int i = right; i >= left; i--) {
                resList.add(array[down][i]);
            }

            //向上逼近
            down--;
            if (up > down)
                break;
            //最左边一列向上打印
            for (int i = down; i >= up; i--) {
                resList.add(array[i][left]);
            }
            left++;
            if (left > right)
                break;
        }
        return resList;
    }
}
