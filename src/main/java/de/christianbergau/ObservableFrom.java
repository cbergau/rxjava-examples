package de.christianbergau;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @see "http://reactivex.io/documentation/operators/from.html"
 */
public class ObservableFrom {
    public static void main(String... args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Observable
                .fromArray(numbers)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
