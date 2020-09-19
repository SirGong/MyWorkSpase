package arrayAlgorithm;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    public static void main(String[] args) {
        int index = 1500;
        long start = System.currentTimeMillis();
        GetUglyNumber_Solution(index);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    //丑数：如果一个数能被2整除就连续除以2，
    //如果一个数能被3整除就连续除以3,
    //如果一个数能被5整除就连续除以5
    public static int GetUglyNumber_Solution(int index) {
        int num = 0;
        int uglyCount = 0;
        while(uglyCount<index){
            ++ num;
            if(isUglyNum(num)){
                uglyCount++;
            }
        }
        return num;
    }
    public static boolean isUglyNum(int number){
        while(number % 2 == 0)
            number /= 2;
        while(number % 3 == 0)
            number /= 3;
        while(number % 5 == 0)
            number /= 5;
        return number == 1? true:false;
    }
}
