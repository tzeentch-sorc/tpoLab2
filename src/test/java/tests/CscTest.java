package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Csc;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CscTest {
    private final double p;
    private final Csc csc;
    private final double x;

    public CscTest(double x) {
        p = 0.00001d;
        csc = new Csc(new SinStub());
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("cscSource.csv");
    }

    @Test
    public void test() {
        assertEquals(1 / Math.sin(x), csc.calcValue(x, p), p);
    }
}
