package de.christianbergau.operators.transforming;

import io.reactivex.Observable;

public class GroupBy {
    public static void main(String... args) {

        Observable
                .range(1, 10)
                .groupBy(t -> {
                    if (t % 2 > 0) {
                        return "Odd Number";
                    } else {
                        return "Even Number";
                    }
                })
                .blockingSubscribe(s -> {
                    System.out.println("grouped observable item key is  " + s.getKey());

                    if ("Even Number".equals(s.getKey())) {
                        s.subscribe(groupedItem -> System.out.println("Items from the even number group observable " + groupedItem));
                    }
                });
    }
}
