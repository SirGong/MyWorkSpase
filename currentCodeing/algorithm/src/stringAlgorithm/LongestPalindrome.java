package stringAlgorithm;

/**
 * 求一个字符串的最大回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //如果字符串长度小于2，直接返回原字符串
        if(s.length()<2){
            return s;
        }
        //将字符串转化为char类型的数组
        char[] strArr = s.toCharArray();
        //定义两个变量，一个start存储当前找到的最大回文字符串的起始位置，
        //maxLength记录字符串的长度(终止位置就是start+ maxLength)
        int start = 0;
        int maxLength = 1;
        //循环遍历字符串数组，从中心到两边扩散找相同，分两种情况，有对称中心点和无对称中心点
        for(int i=0;i<strArr.length;i++){
            //定义左指针和右指针,记录位置（针对有对称中心点的情况）
            int left1 = i-1;
            int right1 =i+1;
            // 判断左边和右边是否越界，同时最左边的字符是否等于最右边的字符
            while(left1 >= 0 && right1 < strArr.length && strArr[left1] == strArr[right1]){
                //判断是否需要更新回文字符串最大长度
                if(right1 - left1 + 1 > maxLength){
                    maxLength = right1 - left1 + 1;
                    //更新最大字符串的起始位置
                    start = left1;
                }
                //左指针向左移动一位
                left1--;
                //右指针向右移动一位
                right1++;
            }

            //定义左指针和右指针,记录位置（针对无对称中心点的情况）
            int left = i;
            int  right = i+1;
            //判断左边和右边是否越界，同时最左边的字符是否等于最右边的字符
            while(left >= 0 && right < strArr.length && strArr[left] == strArr[right]){
                //判断是否需要更新回文字符串最大长度
                if(right - left + 1 > maxLength){
                    maxLength = right - left + 1;
                    //更新最大字符串的起始位置
                    start = left;
                }
                //左指针向左移动一位
                left--;
                //右指针向右移动一位
                right++;
            }
        }
        return s.substring(start,start+maxLength);
    }
}
