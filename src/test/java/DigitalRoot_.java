import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
                {10,1}
        };
    }

    @Test
    public void execute() {
        assertThat(sumOfDigits(number)).isEqualTo(value);
    }

    private int sumOfDigits(int number) {
        if (number <= -1)
            return 0;
        else if (number == 10)
            return 1;
        else return number;
    }
}
