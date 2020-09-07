package com.xzy.test.yongyou;

public class Test {
    public String compress(String str) {
        // write code here
        if (str == null || str.isEmpty())
            return str;
            String des = "";
            char ls = str.charAt(0);
            int count = 1;
            for (int i = 1; i < str.length(); i++) {
                if (ls == str.charAt(i)) {
                    ++count;
                } else {
                    des += ls + "" + (count == 1 ? "" : count);
                    ls = str.charAt(i);
                    count = 1;
                }
            }
            return des + ls + (count == 1 ? "" : count);
    }
}