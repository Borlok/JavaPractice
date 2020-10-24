package com.borlok.javapractice.part1;

public class FooRealisation {
    public FooRealisation() {
        Foo foo = new Foo();
        Thread a = new Thread(foo::first);
        Thread b = new Thread(foo::second);
        Thread c = new Thread(foo::third);
        try {
            a.start();
            a.join();
            b.start();
            b.join();
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
