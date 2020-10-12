package tests;

import logarithmic.Ln;
import logarithmic.Log2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import stubs.Driver;
import stubs.LnStub;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Log2Test {
    private final double p;
    private final Log2 log2;
    private final double x;

    public Log2Test(double x) {
        p = 0.00001d;
        log2 = new Log2(new LnStub());
        this.x = x;
    }

    @Parameterized.Parameters
    public static List<Double> data() {
        return new Driver().supply("log2Source.csv");
    }

    @Test
    public void test() {
                assertEquals(Math.log(x) / Math.log(2), log2.calcValue(x, p), p);
    }
}
