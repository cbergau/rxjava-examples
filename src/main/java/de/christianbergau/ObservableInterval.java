package de.christianbergau;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @see "http://reactivex.io/documentation/operators/interval.html"
 */
public class ObservableInterval {
    public static void main(String... args) {
        Observable
                .interval(3, TimeUnit.SECONDS)
                .timeInterval()
                .take(3)
                .blockingSubscribe(System.out::println);
    }
}
