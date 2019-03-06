package de.christianbergau.operators.transforming;

import io.reactivex.Observable;

/**
 * @see "http://reactivex.io/documentation/operators/range.html"
 */
public class Buffer {
    public static void main(String... args) {
        Observable.range(0, 12)
                .buffer(3)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
