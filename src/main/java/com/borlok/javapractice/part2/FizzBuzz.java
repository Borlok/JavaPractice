package com.borlok.javapractice.part2;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    private int count = 1;
    private final int end;
    private volatile boolean shutdown = false;
    private final Semaphore semaphore;

    public FizzBuzz(int n) {
        end = n;
        semaphore = new Semaphore(1);
    }

    public void counter() {
        if (count == end) {
            shutdown = true;
            System.out.print(".");
        } else {
            count++;
            System.out.print(", ");
        }
    }

    public void fizz() {
        while (!shutdown) {
            try {
                semaphore.acquire();
                if ((count % 3) == 0 && (count % 5) != 0) {
                    System.out.print("fizz");
                    counter();
                }
            } catch (InterruptedException e) {
                System.err.println("Проблема в fizz()");
            }
            semaphore.release();
        }
    }


    public void buzz() {
        while (!shutdown) {
            try {
                semaphore.acquire();
                if ((count % 3) != 0 && (count % 5) == 0) {
                    System.out.print("buzz");
                    counter();
                }
            } catch (InterruptedException e) {
                System.err.println("Проблема в buzz()");
            }
                semaphore.release();
        }
    }

    public void fizzBuzz() {
        while (!shutdown) {
            try {
                semaphore.acquire();
                if ((count % 3) == 0 && (count % 5) == 0) {
                    System.out.print("fizzBuzz");
                    counter();
                }
            } catch (InterruptedException e) {
                System.err.println("Проблема в fizzBuzz()");
            }
            semaphore.release();
        }
    }

    public void number() {
        while (!shutdown) {
            try {
                semaphore.acquire();
                if ((count % 3) != 0 && (count % 5) != 0) {
                    System.out.print(count);
                    counter();
                }
            } catch (InterruptedException e) {
                System.err.println("Проблема в num()");
            }
            semaphore.release();
        }
    }
}
