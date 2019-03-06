package de.christianbergau.operators.transforming;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static void main(String... args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        Observable.fromIterable(numbers)
                .map(number -> number * 2)
                .blockingSubscribe(System.out::println);
    }
}
