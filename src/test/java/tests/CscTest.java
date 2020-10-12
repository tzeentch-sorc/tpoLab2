package tests;

import org.junit.Before;
import org.junit.Test;
import stubs.Driver;
import stubs.SinStub;
import trigonometry.Cos;
import trigonometry.Csc;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CscTest {
    private double p;
    private Csc csc;

    @Before
    public void prepare() {
        p = 0.00001d;
        csc = new Csc(new SinStub());
    }

    @Test
    public void test() {
        List<Double> values = new Driver().supply("cscSource.csv");
        values.forEach(x ->
                assertEquals(1/Math.sin(x), csc.calcValue(x, p), p));
    }
}
