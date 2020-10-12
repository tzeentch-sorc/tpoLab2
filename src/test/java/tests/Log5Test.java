package tests;

import logarithmic.Ln;
import logarithmic.Log5;
import org.junit.Before;
import org.junit.Test;
import stubs.Driver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Log5Test {
    private double p;
    private Log5 log5;

    @Before
    public void prepare() {
        p = 0.00001d;
        log5 = new Log5(new Ln());
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("log5Source.csv");
        values.forEach(x ->
                assertEquals(Math.log(x) / Math.log(5), log5.calcValue(x, p), p));
    }
}
