package com.example.xiyoubei;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumberTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        BigInteger big1 = null;
        BigInteger big2 = null;
        String[] add = new String[n];
        String[] subtract = new String[n];
        int i = 0;
        while (n-- != 0) {
            String str1 = sc.nextLine();
            big1 = new BigInteger(str1);
            String str2 = sc.nextLine();
            big2 = new BigInteger(str2);
            add[i] = big1.add(big2).toString();
            subtract[i] = big1.subtract(big2).toString();
            i++;
        }
        for (String str: add) {
            System.out.println(str);
        }
        for (String str: subtract) {
            System.out.println(str);
        }
    }
}
