import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
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
                {20,2}
        };
    }

    @Test
    public void execute() {
        assertThat(sumOfDigits(number)).isEqualTo(value);
    }

    private int sumOfDigits(int number) {
        if (number <= -1)
            return 0;
        else if (number >= 10) {
            String digits = Integer.toString(number);
            int[] digitBreaker = getDigitArray(digits);
            int res = 0;
            for (int item : digitBreaker) {
                res += item;
            }
            return res;
        }
        else return number;
    }

    private int[] getDigitArray(String digits) {
        return iterate(0, l->l+1)
                .limit(digits.length())
                .boxed()
                .mapToInt( i -> parseInt(digits.substring(i,i+1)))
                .toArray();
    }
}
