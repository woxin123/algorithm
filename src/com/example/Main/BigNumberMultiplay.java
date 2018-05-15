package com.example.Main;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumberMultiplay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        BigNumberMultiplay b = new BigNumberMultiplay();
        System.out.println(b.multiplay(num1, num2));
    }

    public String multiplay(String num1, String num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, '0');
        for (int i = 0; i < num1.length(); i++) {
            int addFlag = 0;
            int multipFlag = 0;
            for (int j = 0; j < num2.length(); j++) {
                // 两数相乘 + 乘法进位
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + multipFlag;
                // 乘法进位
                multipFlag = temp / 10;
                // 两个数相乘得到的只有一位的一个结果
                temp = temp % 10;
                // 之前的结果 + 加法进位 + 两位数相乘得到的结果
                int temp1 = result[i + j] - '0' + addFlag + temp;
                // 计算得到加法进位
                addFlag = temp1 / 10;
                // 最终的结果
                result[i + j] = (char) (temp1 % 10 + '0');
            }
            result[i + num2.length()] = (char) (addFlag + multipFlag + '0');
        }
        String resultString = reverse(String.valueOf(result));
        if (resultString.startsWith("0"))
            resultString = resultString.substring(resultString.indexOf("0") + 1);
        return resultString;
    }

    private String reverse(String num) {
        StringBuilder result = new StringBuilder();
        char[] str = num.toCharArray();
        for (int i = str.length - 1; i >= 0; i--) {
            result.append(str[i]);
        }
        return result.toString();
    }

}
