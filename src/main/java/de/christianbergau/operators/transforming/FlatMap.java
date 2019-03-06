package de.christianbergau.operators.transforming;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {
    public static void main(String... args) {
        List<String> sentences = new ArrayList<>();
        sentences.add("Ladybug! Ladybug!");
        sentences.add("Fly away home.");
        sentences.add("Your house is on fire.");
        sentences.add("And your children all gone.");

        Observable.fromIterable(sentences)
                .flatMap(s -> Observable.fromArray(s.split(" ")))
                .blockingSubscribe(System.out::println);
    }
}
