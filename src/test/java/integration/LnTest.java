package integration;

import logarithmic.Ln;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LnTest {
    private final double p;
    private final Ln ln;
    private final double x;

    public LnTest(double x) {
        p = 0.00001d;
        ln = new Ln();
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("lnSource.csv");
    }

    @Test
    public void test() {
        assertEquals(Math.log(x), ln.calcValue(x, p), p);
    }
}
