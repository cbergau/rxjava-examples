package de.christianbergau;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * @see "http://reactivex.io/documentation/operators/repeat.html"
 */
public class ObservableRepeat {
    public static void main(String... args) {
        ObservableOnSubscribe<Object> objectObservableOnSubscribe = emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);

                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond!"));
                    break;
                }
            }
        };

        Observable.create(objectObservableOnSubscribe)
                .repeat(5)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
