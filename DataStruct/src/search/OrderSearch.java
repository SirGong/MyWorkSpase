package search;

public class OrderSearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 8, 4, 7, 9, 6, 3};
        int index = orderSearch(arr, 0);
        if (index != -1) {
            System.out.println("OK：" + index);
        } else {
            System.out.println("ERROR");
        }
    }

    public static int orderSearch(int[] arr, int k) {
        //找到一个就返回
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
