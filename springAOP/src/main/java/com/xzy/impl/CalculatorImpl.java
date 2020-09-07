package com.xzy.impl;


import com.xzy.intr.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {

    public int add(int i, int j) {
        return i + j;
    }


    public int sub(int i, int j) {
        return i - j;
    }


    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
