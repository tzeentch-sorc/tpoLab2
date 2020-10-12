package tests;

import logarithmic.Ln;
import logarithmic.Log2;
import org.junit.Before;
import org.junit.Test;
import stubs.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Log2Test {
    private double p;
    private Log2 log2;

    @Before
    public void prepare() {
        p = 0.00001d;
        log2 = new Log2(new Ln());
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("log2Source.csv");
        values.forEach(x ->
                assertEquals(Math.log(x) / Math.log(2), log2.calcValue(x, p), p));
    }
}
