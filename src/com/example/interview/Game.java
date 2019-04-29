package com.example.interview;

import java.util.Scanner;

/**
 * @author mengchen
 * @time 19-4-28 下午9:18
 */

public class Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T;
        T = s.nextInt();
        int b,n,a;

        for(int i = 0; i<T; i++){
            a = s.nextInt();
            b = s.nextInt();
            n = s.nextInt();
            if(a==1){
                System.out.println("A&B");
                continue;
            }
            double tmp,tmp1,tmp2;
            int count = 0;

            while(true){
                tmp1 = Math.pow(a+1, b);
                tmp2 = Math.pow(a, b+1);
                if(tmp1<tmp2){
                    a = a+1;
                    tmp = tmp1;
                }else{
                    b = b+1;
                    tmp = tmp2;
                }
                count++;
                if(tmp >= n || count >2){
                    break;
                }
            }
            if(count %2 == 1){
                System.out.println("A");
            }else{
                System.out.println("B");
            }
        }
    }
}