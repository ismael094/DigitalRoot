import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.stream.IntStream.iterate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class DigitalRoot_ {
    private final int number;
    private final int value;

    public DigitalRoot_(int number, int value) {
        this.number = number;
        this.value = value;
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][] {
                {-10,0},
                {-1,0},
                {0,0},
                {8, 8},
                {10,1},
                {11,2},
                {20,2},
                {99,9}
        };
    }

    @Test
    public void execute() {
        assertThat(digitalRootOf(number)).isEqualTo(value);
    }

    private int digitalRootOf(int number) {
        if (number <= -1) return 0;
        return sumOf(Integer.toString(number)) >=10 ? digitalRootOf(sumOf(Integer.toString(number))) : sumOf(Integer.toString(number));
    }

    private int sumOf(String digits) {
        return iterate(0, l->l+1)
                .limit(digits.length())
                .boxed()
                .map( i -> parseInt(digits.substring(i,i+1)))
                .collect(Collectors.summingInt(Integer::intValue));
    }
}
