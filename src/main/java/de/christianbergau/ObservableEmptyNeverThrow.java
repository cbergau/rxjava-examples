package de.christianbergau;

import io.reactivex.Observable;

/**
 * The Empty, Never, and Throw operators generate Observables with very specific
 * and limited behavior. These are useful for testing purposes, and sometimes also
 * for combining with other Observables or as parameters to operators that expect other
 * Observables as parameters.
 *
 * @see "http://reactivex.io/documentation/operators/empty-never-throw.html"
 */
public class ObservableEmptyNeverThrow {
    public static void main(String... args) {
        Observable.empty().subscribe(System.out::println, Throwable::printStackTrace);
        Observable.never().subscribe(System.out::println, Throwable::printStackTrace);
        Observable.error(new RuntimeException()).subscribe(System.out::println, Throwable::printStackTrace);
    }
}
