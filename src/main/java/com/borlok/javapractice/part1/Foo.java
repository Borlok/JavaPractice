package com.borlok.javapractice.part1;


import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore one = new Semaphore(1);
    private final Semaphore two = new Semaphore(0);
    private final Semaphore three = new Semaphore(0);

    public void first() {
        try {
            one.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("first");
        two.release();
    }

    public void second() {
        try {
            two.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        three.release();
    }

    public void third() {
        try {
            three.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("third");
        one.release();
    }
}
