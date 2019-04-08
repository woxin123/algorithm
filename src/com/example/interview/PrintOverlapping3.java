package com.example.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mengchen
 * @time 19-3-27 下午4:28
 */
public class PrintOverlapping3 {


    public static final ReentrantLock lock = new ReentrantLock();

    public static final Condition condition1 = lock.newCondition();

    public static final Condition condition2 = lock.newCondition();

    public static final Condition condition3 = lock.newCondition();

    public static void main(String[] args) {

        new Thread(() -> {
            lock.lock();
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                condition2.signal();
                if (i == 26) {
                    break;
                }
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            lock.unlock();
        }).start();


        new Thread(() -> {
            lock.lock();
                for (char i = 'a'; i <= 'z'; i++) {
                    System.out.print(i);
                    condition3.signal();
                    if (i == 'z') {
                        break;
                    }
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.print(i);
                condition1.signal();
                if (i == 'Z') {
                    break;
                }
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();
    }

}
