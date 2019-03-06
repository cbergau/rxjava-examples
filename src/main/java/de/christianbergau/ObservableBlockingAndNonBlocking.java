package de.christianbergau;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableBlockingAndNonBlocking {
    public static void main(String... args) {
        Observable
                .interval(3, TimeUnit.SECONDS)
                .timeInterval()
                .take(3)
                .subscribe(t -> {
                    System.out.println("Thread: " + Thread.currentThread());
                    System.out.println("Value: " + t);
                });

        Observable
                .interval(3, TimeUnit.SECONDS)
                .timeInterval()
                .take(3)
                .blockingSubscribe(t -> {
                    System.out.println("Thread: " + Thread.currentThread());
                    System.out.println("Value: " + t);
                });
    }
}
