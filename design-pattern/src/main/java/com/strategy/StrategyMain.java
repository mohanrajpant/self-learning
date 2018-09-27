package com.strategy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.strategy.Discounter.christmasDiscounter;
import static com.strategy.Discounter.easterDiscounter;
import static com.strategy.Discounter.newYearDiscounter;

public class StrategyMain {
    public static void main(String[] args) {
        List<Discounter> discounters = Arrays.asList(
            christmasDiscounter(),
            newYearDiscounter(),
            easterDiscounter());

        Discounter finalDiscounter = discounters.stream()
            .reduce(v -> v, Discounter::combine);

        System.out.println("The total cost after discount is " + BigDecimal.valueOf(100)
            .subtract(finalDiscounter.apply(BigDecimal.valueOf(100))));
    }
}
