package basicfunctional;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        IntSupplier intSupplier = () -> 10;

        BinaryOperator<String> binaryOperator = (String s, String i) -> s + i;

        String apply = BinaryOperator.minBy(Comparator.comparingInt(String::length)).apply("adfd", "adfd");

    }
}
