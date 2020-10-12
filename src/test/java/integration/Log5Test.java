package integration;

import logarithmic.Log5;
import org.junit.Test;
import org.junit.runners.Parameterized;
import stubs.Driver;
import stubs.LnStub;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Log5Test {
    private final double p;
    private final Log5 log5;
    private final double x;

    public Log5Test(double x) {
        p = 0.00001d;
        log5 = new Log5(new LnStub());
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("log5Source.csv");
    }

    @Test
    public void test() {
        assertEquals(Math.log(x) / Math.log(5), log5.calcValue(x, p), p);
    }
}
