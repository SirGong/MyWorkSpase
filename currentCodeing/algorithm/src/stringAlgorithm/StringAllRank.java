package stringAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的全排列
 */
public class StringAllRank {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(Permutation(str));
    }

    /*
    1、将字符串分为两个部分，第一个字符和后面的所有字符
    2、将第一个字符一次和后面的字符进行交换，每次交换就会产生一个新的序列
     */
    public static ArrayList<String> permutationHelp(int i , char[] ch, ArrayList<String> res) {
        if(i == ch.length-1){
            String value = String.valueOf(ch);
            if(!res.contains(value)){
                res.add(value);
            }
        }else {
            for (int j = i; j < ch.length; j++) {
                //依次交换
                swap(i,j,ch);
                //进行递归
                permutationHelp(i+1,ch,res);
                //换回来，方便回溯
                swap(i,j,ch);
            }
        }
        return res;
    }

    private static void swap(int i, int j, char[] ch) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str!= null || str.length()>0){
            char[] chars = str.toCharArray();
            permutationHelp(0,chars,result);
        }
        return result;
    }
}
