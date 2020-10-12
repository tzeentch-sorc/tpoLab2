package integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.Driver;
import trigonometry.Sin;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SinTest {
    private final double p;
    private final Sin sin;
    private final double x;

    public SinTest(double x) {
        p = 0.0001d;
        sin = new Sin();
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("sinSource.csv");
    }

    @Test
    public void test() {
        assertEquals(Math.sin(x), sin.calcValue(x, p), p);
    }
}
