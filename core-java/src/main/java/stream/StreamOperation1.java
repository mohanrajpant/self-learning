package stream;

import stream.domain.Dish;
import stream.domain.Dish.CalorieType;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static stream.domain.Dish.CalorieType.*;
import static stream.domain.Dish.menu;

public class StreamOperation1 {
    public static void main(String[] args) {

        // 1. Sum of calories in all the dishes
        System.out.println("1. Sum of calories in the dishes");
        int totalCalories1 = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();

        Integer totalCalories2 = menu.stream()
            .collect(summingInt(Dish::getCalories));

        Optional<Integer> totalCalories3 = menu.stream()
            .map(Dish::getCalories).reduce(Integer::sum);

        Integer totalCalories4 = menu.stream()
            .map(Dish::getCalories)
            .reduce(0, (a, b) -> a + b);

        Integer totalCalories5 = menu.stream()
            .collect(reducing(0, Dish::getCalories, (a, b) -> a + b));

        System.out.printf("\ntotalCalories1 (%s)\ntotalCalories2 (%s)\ntotalCalories3 (%s)\ntotalCalories4 (%s)\ntotalCalories5 (%s)\n\n",
            totalCalories1, totalCalories2, totalCalories3, totalCalories4, totalCalories5);

        // 2. Summarising (This include Count, Min, Max, Sum, Average
        System.out.println(" 2. Summarising (This include Count, Min, Max, Sum, Average");
        IntSummaryStatistics intSummaryStatistics = menu.stream()
            .collect(summarizingInt(Dish::getCalories));

        System.out.printf("\n%s\n\n", intSummaryStatistics);

        // 3. Joining string
        System.out.println("3. Joining string");
        String joinDishNameByComma= menu.stream().map(Dish::getName).collect(joining(","));
        System.out.printf("\n%s\n\n", joinDishNameByComma);


        // 4. Grouping by
        System.out.println(" 4. Grouping by");

        Map<CalorieType, List<Dish>> disheBasedOnDietType =
            menu.stream().collect(groupingBy(StreamOperation1::getCalorieType));
        System.out.println(disheBasedOnDietType);
        System.out.println();


        // 5. Multi Level Grouping
        System.out.println("5. Multi Level Grouping");
        Map<Dish.Type, Map<CalorieType, List<Dish>>> dishGroupedByTypeAndCalorieType = menu.stream()
            .collect(
                groupingBy(
                    Dish::getType,
                    groupingBy(StreamOperation1::getCalorieType)
                )
            );
        System.out.println(dishGroupedByTypeAndCalorieType);
        System.out.println();

        // 6. Find Dish with max calorie for each Dish type
        System.out.println("6. Find Dish with max calorie for each Dish type");
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
            .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Dish> mostCalorieDishByType = menu.stream()
            .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCalorieDishByType);
        System.out.println();

        // 7. Counting the dish in each subgroup based on DishType

        System.out.println("7. Counting the dish in each subgroup based on DishType");

        Map<Dish.Type, Integer>  dishCountPerType = menu.stream()
            .collect(groupingBy(Dish::getType, reducing(0, dish -> 1, (a, b) -> a + b)));

        Map<Dish.Type, Long> dishCountPerTypeAlernativeApproach = menu.stream()
            .collect(groupingBy(Dish::getType, counting()));

        System.out.println(dishCountPerType);
        System.out.println(dishCountPerTypeAlernativeApproach);
        System.out.println();

        // 8. Partitioning
        System.out.println("8. Partitioning");
        Map<Boolean, List<Dish>> partitionMenu = menu.stream()
            .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionMenu);
        System.out.println();

        // 9. Partitioning numbers into prime and non prime numbers


        // ----------------------------------------------------


        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Dish> dishesWithCaloriesAbove300 = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .limit(3)
            .collect(toList());
        integers.stream()
            .filter(i -> i % 2 == 0)
            .distinct()
            .forEach(System.out::println);

        List<Integer> dishNameLengths = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(toList());

        // flattening of streams -- difficult to understand
        List<String> words = Arrays.asList("Hello", "World");
        
        Stream<String[]> stream = words.stream()
            .map(word -> word.split(""));
        
        Stream<Stream<String>> streamStream = words.stream()
            .map(word -> word.split(""))
            .map(array -> Stream.of(array));

        Stream<String> stringStream = words.stream()
            .map(word -> word.split(""))
            .flatMap(array -> Stream.of(array));

        Stream<String> stringStream1 = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream);

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        //Quiz
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<List<Integer>> collect = list1.stream()
            .flatMap(i -> list2.stream().map(j -> Arrays.asList(i, j)))
            .collect(toList());

        collect.stream().forEach(System.out::println);

        //matching
        boolean allMatch = menu.stream()
            .allMatch(Dish::isVegetarian);
        System.out.println(allMatch);

        boolean anyMatch = menu.stream()
            .anyMatch(Dish::isVegetarian);
        System.out.println(anyMatch);


        //reducing
        Integer totalCalorieUsingReduce = menu.stream()
            .map(Dish::getCalories)
            .reduce(0, (a, b) -> a + b);
        System.out.println("Total calories is " + totalCalorieUsingReduce);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //sum
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        Integer alternativeSum = numbers.stream().reduce(0, Integer::sum);
        Integer mutliplication = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Sum of " + numbers + " is " + sum);
        System.out.println("Mutliplication of " + numbers + " is " + mutliplication);

    }

    private static CalorieType getCalorieType(Dish dish) {
        if (dish.getCalories() <= 400) return DIET;
        else if (dish.getCalories() <= 700) return NORMAL;
        else return FAT;
    }

    public boolean isPrime(int number) {
        return IntStream.range(2, number)
            .noneMatch(i -> number % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
            .boxed()
            .collect(
                partitioningBy(candidate -> isPrime(candidate)));
    }
}
