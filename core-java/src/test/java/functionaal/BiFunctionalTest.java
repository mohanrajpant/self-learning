package functionaal;

import org.junit.Test;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionalTest {

    @Test
    public void biFunctionComposition() {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> addAndMutliplyBy5 = add.andThen(x -> x * 5);

        assertThat(addAndMutliplyBy5.apply(4, 5)).isEqualTo(45);
    }
}
