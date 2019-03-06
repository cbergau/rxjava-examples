package de.christianbergau;

import io.reactivex.Observable;

/**
 * You can create an Observable from scratch by using the Create operator.
 * You pass this operator a function that accepts the observer as its parameter.
 * Write this function so that it behaves as an Observable — by calling the observer’s onNext,
 * onError, and onCompleted methods appropriately.
 *
 * @see "http://reactivex.io/documentation/operators/create.html"
 */
public class ObservableCreate {
    public static void main(String... args) {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);

                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond!"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }
}
