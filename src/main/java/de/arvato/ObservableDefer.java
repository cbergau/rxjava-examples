package de.arvato;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * The Defer operator waits until an observer subscribes to it, and then it generates
 * an Observable, typically with an Observable factory function.
 * It does this afresh for each subscriber, so although each subscriber may think
 * it is subscribing to the same Observable, in fact each subscriber gets its own
 * individual sequence.
 *
 * @see "http://reactivex.io/documentation/operators/defer.html"
 */
public class ObservableDefer {
    public static void main(String... args) {
        // Einen Observable erstellen
//        Observable<Object> observable = Observable.defer(() -> {
//            Observable.
//        });
//
//        // subscribe sorgt dafür, dass der Observable "gestartet" wird.
//        Consumer<Object> onNextConsumer = System.out::println;
//        Consumer<Throwable> onErrorConsumer = Throwable::printStackTrace;
//
//        observable.subscribe(onNextConsumer, onErrorConsumer);
    }
}
