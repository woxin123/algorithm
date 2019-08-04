package com.example.Main;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    static Stack<Integer> stack = new Stack();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        zhuan(n);
        while (!stack.empty())
        System.out.print(stack.pop());
        System.out.println();
    }

     static void zhuan (int n) {
        int m = 0;
        while (n > 0) {
            int temp = n % 2;
            n = n / 2;
            stack.add(temp);
        }
    }
}
