package tests;

import logarithmic.Ln;
import org.junit.Before;
import org.junit.Test;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Csc;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LnTest {
    private double p;
    private Ln ln;

    @Before
    public void prepare() {
        p = 0.00001d;
        ln = new Ln();
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("lnSource.csv");
        values.forEach(x ->
                assertEquals(Math.log(x), ln.calcValue(x, p), p));
    }
}
