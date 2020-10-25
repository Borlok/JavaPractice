package com.borlok.javapractice.part1;


public class FooRealisation {
    public FooRealisation() {
        Foo foo = new Foo();
        new Thread(foo::third).start();
        new Thread(foo::second).start();
        new Thread(foo::first).start();
    }
}
