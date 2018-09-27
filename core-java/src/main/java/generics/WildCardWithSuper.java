package generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class WildCardWithSuper {
    public static void main(String[] args) {

        List<Number> numbers = Arrays.asList(1, 3.5, 3.99, 6);
        List<Integer> integers = Arrays.asList(4, 8);

        copy(numbers, integers);

        List<Animal> animals = Arrays.asList(new Dog(), new Cat());
        List<Cow> cows = Arrays.asList(new Cow(), new Cow());

        copy(animals, cows);

        List<? extends Animal> catsAndDogs = Arrays.asList(new Cow(), new Dog());

        copy(animals, catsAndDogs);




    }

    static <T> void copy(List<? super T> des, List<T> src) {
        IntStream.range(0, src.size())
                .forEach(i -> des.set(i, src.get(i)));

        System.out.println(des);
    }


    interface Animal {}
    static class Dog implements Animal {}
    static class Cat implements Animal {}
    static class Cow implements Animal {}
}
