package com.example.interview;

/**
 * @author mengchen
 * @time 19-3-27 下午4:28
 */
public class PrintOverlapping {


    public static final Object lock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 26; i++) {
                    System.out.print(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (lock) {
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.print(i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
