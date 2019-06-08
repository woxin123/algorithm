package com.example.剑指offer;

/**
 * @author: mengchen
 * Create by 18-4-22
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class DoublePower {

    public static void main(String[] args) {
        DoublePower doublePower = new DoublePower();
        System.out.println(doublePower.Power(2, 3));
    }

    public double Power(double base, int exponent) {
        double sum = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                sum *= base;
            }
        } else if (exponent < 0){
            for (int i = 0; i < -exponent; i++) {
                sum /= base;
            }
        } else {
            sum = 1;
        }
        return sum;
    }
}
