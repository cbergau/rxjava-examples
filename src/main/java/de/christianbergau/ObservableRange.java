package de.christianbergau;

import io.reactivex.Observable;

/**
 * @see "http://reactivex.io/documentation/operators/range.html"
 */
public class ObservableRange {
    public static void main(String... args) {
        Observable.range(0, 5)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
