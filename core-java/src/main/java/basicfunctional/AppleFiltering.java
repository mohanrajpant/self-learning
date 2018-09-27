package basicfunctional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class AppleFiltering {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("green", 25),
                new Apple("red", 15),
                new Apple("yellow", 54));


        apples.stream()
                .filter(Apple::isGreenApple)
                .forEach(System.out::println);

//        apples.stream()
//                .filter(Apple::isRedApple)
//                .forEach(System.out::println);

        // lambda
        apples.stream()
                .filter(a -> a.getColor().equals("green"))
                .forEach(System.out::println);

        apples.stream()
                .filter(AppleUtils::isWeightLessThan30)
                .forEach(System.out::println);

        apples.sort(Comparator.comparing(Apple::getWeight));

        //sort by decreasing weight
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());


        // sorting string
        List<String> str = Arrays.asList("a", "b", "A", "B", "M");

        str.sort(String::compareToIgnoreCase); // ?

        // creating object using constructor reference
//        Supplier<Apple> c1 = Apple::new;
        BiFunction<String, Integer, Apple> bf1 = Apple::new;
        Apple whiteApple = bf1.apply("white", 20);


        // composing Predicate

        // composing Function

    }

    // List<Title> titles = new ArrayList<>();


}
