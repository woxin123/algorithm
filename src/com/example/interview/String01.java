package com.example.interview;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author mengchen
 * @time 19-4-5 下午8:23
 */
public class String01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            char ch1 = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch1);
            } else {
                char ch2 = stack.peek();
                if ((ch1 == '0' && ch2 == '1')
                        || (ch1 == '1' && ch2 == '0')) {
                    stack.pop();
                } else {
                    stack.push(ch1);
                }
            }
            i++;
        }
        System.out.println(stack.size());
    }

}
