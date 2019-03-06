package de.christianbergau.operators.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

import java.util.ArrayList;
import java.util.List;

public class Scan {
    public static void main(String... args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Observable.fromIterable(numbers)
                .scan((int1, int2) -> int1 + int2)
                .blockingSubscribe(System.out::println);
    }
}
