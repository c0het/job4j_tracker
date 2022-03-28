package ru.job4j.lambda;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FunctionInRangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionInRange.function(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionInRange.function(4, 7, x -> 2 * Math.pow(x, 2) + 2 * x + 3);
        List<Double> expected = Arrays.asList(43D, 63D, 87D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowingFunction() {
        List<Double> result = FunctionInRange.function(6, 9, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(64D, 128D, 256D);
        assertThat(result, is(expected));
    }
}