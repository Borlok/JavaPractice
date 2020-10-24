package com.borlok.javapractice.part2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzRealization {
    public FizzBuzzRealization() {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.execute(fizzBuzz::fizz);
        es.execute(fizzBuzz::buzz);
        es.execute(fizzBuzz::fizzBuzz);
        es.execute(fizzBuzz::number);
        es.shutdown();
    }
}
