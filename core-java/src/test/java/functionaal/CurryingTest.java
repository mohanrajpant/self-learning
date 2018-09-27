package functionaal;

import org.junit.Test;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class CurryingTest {

    @Test
    public void applyCurrying() {
        final Integer curriedValue = curry(mutliply(), 5).apply(5);
        assertThat(curriedValue).isEqualTo(25);
    }

    private IntBinaryOperator mutliply() {
        return (x, y) -> x* y;
    }

    IntFunction<Integer> curry(IntBinaryOperator operator, int mutliplier) {
        return val -> operator.applyAsInt(val, mutliplier);
    }
}
