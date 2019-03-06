package de.christianbergau;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @see "http://reactivex.io/documentation/operators/just.html"
 */
public class ObservableJust {
    public static void main(String... args) {
        Observable.just(1, 2)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
