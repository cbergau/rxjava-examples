package de.arvato;

import io.reactivex.*;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class App {
    public static void main(String... args) throws InterruptedException {
        Flowable.just("Hello World").subscribe(new Consumer<String>() {
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        // Definiert den Flow, Daten werden noch nicht verarbeitet oder weitergeleitet
        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(value -> value * value)
                .filter(value -> value % 3 == 0);

        // Subscription, jetzt wird der Flow angestoßen
        flow.subscribe(System.out::println);

//        Observable.create(emitter -> {
//            while (!emitter.isDisposed()) {
//                long time = System.currentTimeMillis();
//                emitter.onNext(time);
//                if (time % 2 != 0) {
//                    emitter.onError(new IllegalStateException("Odd millisecond!"));
//                    break;
//                }
//            }
//        }).subscribe(System.out::println, Throwable::printStackTrace);

        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println); // main Thread

        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println); // main Thread

        /*
            Schedulers.computation():   Run computation intensive work on a fixed number of dedicated threads in the background.
                                        Most asynchronous operator use this as their default Scheduler.
            Schedulers.io():            Run I/O-like or blocking operations on a dynamically changing set of threads.
            Schedulers.single():        Run work on a single thread in a sequential and FIFO manner.
            Schedulers.trampoline():    Run work in a sequential and FIFO manner in one of the participating threads, usually for testing purposes.
         */
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish


    }
}
