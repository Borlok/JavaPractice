package com.borlok.javapractice.part2;

import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {
    private int count = 1;
    private final int end;
    private final ReentrantLock lock;

    public FizzBuzz(int n) {
        end = n;
        lock = new ReentrantLock();
    }

    public void fizz() {
        while (count < end) {
            try {
                lock.lock();
                if ((count % 3) == 0 && (count % 5) != 0) {
                    System.out.print("fizz, ");
                    count++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() {
        while (count < end) {
            try {
                lock.lock();
                if ((count % 5) == 0 && (count % 3) != 0) {
                    System.out.print("buzz, ");
                    count++;
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public void fizzBuzz() {
        while (count < end) {
            try {
                lock.lock();
                if ((count % 3) == 0 && (count % 5) == 0) {
                    System.out.print("fizzBuzz. ");
                    count++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() {
        while (count < end) {
            try {
                lock.lock();
                if ((count % 3) != 0 && (count % 5) != 0) {
                    System.out.print(count + ", ");
                    count++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
